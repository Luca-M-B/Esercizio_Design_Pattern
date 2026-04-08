package service;

import pizze_base.*;
import decorators.*;

import java.sql.*;
import java.util.*;

public class PizzaDAO {

    public Pizza getPizzaById(int idPizza) throws Exception {
        Connection c = DBConnection.getInstance().getConnection();

        // Recupera la pizza base
        PreparedStatement psBase = c.prepareStatement(
                "SELECT * FROM pizza_base pb JOIN pizza p ON pb.id = p.id_pizza_base WHERE p.id=?"
        );
        psBase.setInt(1, idPizza);
        ResultSet rsBase = psBase.executeQuery();
        if (!rsBase.next()) return null;

        String nomeBase = rsBase.getString("nome");
        double prezzoBase = rsBase.getDouble("prezzo_base");

        // Crea la pizza base
        Pizza pizza;
        switch (nomeBase) {
            case "Margherita" -> pizza = new Margherita();
            case "BaseRossa" -> pizza = new BaseRossa();
            case "BaseBianca" -> pizza = new BaseBianca();
            default -> pizza = new Margherita(); // fallback
        }

        // Recupera ingredienti aggiunti
        PreparedStatement psIng = c.prepareStatement(
                "SELECT i.nome FROM ingrediente i " +
                "JOIN pizza_ingrediente pi ON i.id = pi.id_ingrediente " +
                "WHERE pi.id_pizza = ?"
        );
        psIng.setInt(1, idPizza);
        ResultSet rsIng = psIng.executeQuery();

        // Applica decoratori per ogni ingrediente
        while (rsIng.next()) {
            String ing = rsIng.getString("nome");
            pizza = switch (ing) {
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
}