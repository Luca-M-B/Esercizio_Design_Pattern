package service;

import pizze_base.*;
import decorators.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAO {

    // Recupera pizza con decoratori (ingredienti)
    public Pizza getPizzaById(int idPizza) throws Exception {
        Connection c = DBConnection.getInstance().getConnection();

        // Recupera pizza base associata
        PreparedStatement psBase = c.prepareStatement(
                "SELECT pb.nome, p.prezzo_totale FROM pizza p " +
                "JOIN pizza_base pb ON p.id_pizza_base = pb.id " +
                "WHERE p.id=?"
        );
        psBase.setInt(1, idPizza);
        ResultSet rsBase = psBase.executeQuery();

        if (!rsBase.next()) return null;

        String nomeBase = rsBase.getString("nome");

        // Crea pizza base
        Pizza pizza = switch (nomeBase) {
            case "Margherita" -> new Margherita();
            case "BaseRossa" -> new BaseRossa();
            case "BaseBianca" -> new BaseBianca();
            default -> new Margherita();
        };

        // Recupera ingredienti
        PreparedStatement psIng = c.prepareStatement(
                "SELECT i.nome FROM pizza_ingrediente pi " +
                "JOIN ingrediente i ON pi.id_ingrediente = i.id " +
                "WHERE pi.id_pizza = ?"
        );
        psIng.setInt(1, idPizza);
        ResultSet rsIng = psIng.executeQuery();

        while(rsIng.next()) {
            String ing = rsIng.getString("nome");
            pizza = switch(ing) {
                case "Mozzarella" -> new Mozzarella(pizza);
                case "Funghi" -> new Funghi(pizza);
                case "Salame" -> new Salame(pizza);
                case "SalamePiccante" -> new SalamePiccante(pizza);
                case "ProsciuttoCrudo" -> new ProsciuttoCrudo(pizza);
                default -> pizza;
            };
        }

        return pizza;
    }


    // Crea nuova pizza con base e ingredienti
    public int creaPizza(int idBase, List<String> ingredienti) throws Exception {
        Connection c = DBConnection.getInstance().getConnection();

        // Calcola prezzo totale (base + ingredienti)
        double prezzoBase = 0;
        PreparedStatement psBase = c.prepareStatement("SELECT prezzo_base FROM pizza_base WHERE id=?");
        psBase.setInt(1, idBase);
        ResultSet rs = psBase.executeQuery();
        if(rs.next()) prezzoBase = rs.getDouble("prezzo_base");

        double prezzoTotale = prezzoBase;
        for(String ing : ingredienti) {
            switch(ing) {
                case "Mozzarella" -> prezzoTotale += 1.5;
                case "Funghi" -> prezzoTotale += 1.5;
                case "Salame" -> prezzoTotale += 2.0;
                case "SalamePiccante" -> prezzoTotale += 2.5;
                case "ProsciuttoCrudo" -> prezzoTotale += 2.0;
            }
        }

        // Inserisce pizza
        PreparedStatement ps = c.prepareStatement(
                "INSERT INTO pizza(id_pizza_base, prezzo_totale) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS
        );
        ps.setInt(1, idBase);
        ps.setDouble(2, prezzoTotale);
        ps.executeUpdate();

        ResultSet keys = ps.getGeneratedKeys();
        int idPizza = 0;
        if(keys.next()) idPizza = keys.getInt(1);

        // Inserisce ingredienti nella tabella pizza_ingrediente
        for(String ing : ingredienti) {
            int idIngrediente = switch(ing) {
                case "Mozzarella" -> 1;
                case "Funghi" -> 2;
                case "Salame" -> 3;
                case "SalamePiccante" -> 4;
                case "ProsciuttoCrudo" -> 5;
                default -> 0;
            };
            if(idIngrediente > 0) {
                PreparedStatement psIng = c.prepareStatement(
                        "INSERT INTO pizza_ingrediente(id_pizza, id_ingrediente) VALUES (?, ?)"
                );
                psIng.setInt(1, idPizza);
                psIng.setInt(2, idIngrediente);
                psIng.executeUpdate();
            }
        }

        return idPizza;
    }

    // Elimina pizza
    public void deletePizza(int idPizza) throws Exception {
        Connection c = DBConnection.getInstance().getConnection();
        PreparedStatement psIng = c.prepareStatement("DELETE FROM pizza_ingrediente WHERE id_pizza=?");
        psIng.setInt(1, idPizza);
        psIng.executeUpdate();

        PreparedStatement psPizza = c.prepareStatement("DELETE FROM pizza WHERE id=?");
        psPizza.setInt(1, idPizza);
        psPizza.executeUpdate();
    }

    // Aggiorna prezzo totale di una pizza
    public void aggiornaPrezzoTotale(int idPizza, double nuovoPrezzo) throws Exception {
        Connection c = DBConnection.getInstance().getConnection();
        PreparedStatement ps = c.prepareStatement("UPDATE pizza SET prezzo_totale=? WHERE id=?");
        ps.setDouble(1, nuovoPrezzo);
        ps.setInt(2, idPizza);
        ps.executeUpdate();
    }

    // TODO - Aggiungi metodo per aggiornare ingredienti di una pizza (aggiungere/rimuovere)

    // Lista tutte le pizze
    public List<Pizza> getAllPizze() throws Exception {
        List<Pizza> lista = new ArrayList<>();
        Connection c = DBConnection.getInstance().getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT id FROM pizza");
        while(rs.next()) {
            lista.add(getPizzaById(rs.getInt("id")));
        }
        return lista;
    }
}