package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pizze_base.Pizza;

public class PizzaBaseDAO {

    public void createPizzaBase(String nome, double prezzoBase) throws Exception {
        Connection c = DBConnection.getInstance().getConnection();
        PreparedStatement ps = c.prepareStatement("INSERT INTO pizza_base(nome, prezzo_base) VALUES (?, ?)");
        ps.setString(1, nome);
        ps.setDouble(2, prezzoBase);
        ps.executeUpdate();
        ps.close();
    }

    public Pizza readPizzaBase(int idPizzaBase) throws Exception {
        Connection c = DBConnection.getInstance().getConnection();
        PreparedStatement ps = c.prepareStatement("SELECT * FROM pizza_base WHERE id=?");
        ps.setInt(1, idPizzaBase);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            String nome = rs.getString("nome");
            // Crea pizza base oggetto (solo Margherita, BaseRossa, BaseBianca)
            return switch(nome) {
                case "Margherita" -> new pizze_base.Margherita();
                case "BaseRossa" -> new pizze_base.BaseRossa();
                case "BaseBianca" -> new pizze_base.BaseBianca();
                default -> new pizze_base.Margherita();
            };
        }
        return null;
    }

    public List<String> getAllPizzeBase() throws Exception {
        List<String> list = new ArrayList<>();
        Connection c = DBConnection.getInstance().getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM pizza_base");
        while(rs.next()) {
            list.add(rs.getString("nome") + " | Prezzo: " + rs.getDouble("prezzo_base"));
        }
        return list;
    }

    public void updatePizzaBase(int idPizzaBase, String nuovoNome, double nuovoPrezzo) throws Exception {
        Connection c = DBConnection.getInstance().getConnection();
        PreparedStatement ps = c.prepareStatement("UPDATE pizza_base SET nome=?, prezzo_base=? WHERE id=?");
        ps.setString(1, nuovoNome);
        ps.setDouble(2, nuovoPrezzo);
        ps.setInt(3, idPizzaBase);
        ps.executeUpdate();
        ps.close();
    }

    public void deletePizzaBase(int idPizzaBase) throws Exception {
        Connection c = DBConnection.getInstance().getConnection();
        PreparedStatement ps = c.prepareStatement("DELETE FROM pizza_base WHERE id=?");
        ps.setInt(1, idPizzaBase);
        ps.executeUpdate();
        ps.close();
    }
}