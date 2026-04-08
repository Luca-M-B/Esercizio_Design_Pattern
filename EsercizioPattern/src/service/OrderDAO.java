package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classi.Ordine;
import pizze_base.Pizza;

public class OrderDAO {
    
     public void creaOrdine(int pizzaId) throws Exception {
        Connection c = DBConnection.getInstance().getConnection();

        PreparedStatement ps = c.prepareStatement(
                "INSERT INTO ordine(id_pizza, stato) VALUES (?, 'IN_PREPARAZIONE')"
        );
        ps.setInt(1, pizzaId);
        ps.executeUpdate();
    }

    public Ordine getOrdine(int id) throws Exception {
        Connection c = DBConnection.getInstance().getConnection();
        PizzaDAO pizzaDAO = new PizzaDAO();

        PreparedStatement ps = c.prepareStatement("SELECT * FROM ordine WHERE id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int pizzaId = rs.getInt("id_pizza");
            Pizza pizza = pizzaDAO.getPizzaById(pizzaId);
            String stato = rs.getString("stato");
            double prezzoTotale = rs.getDouble("prezzo_totale");

            return new Ordine(rs.getInt("id"), pizza, stato, prezzoTotale);
        }
        return null;
    }

    public void aggiornaStato(int id, String stato) throws Exception {
        Connection c = DBConnection.getInstance().getConnection();
        PreparedStatement ps = c.prepareStatement("UPDATE ordine SET stato=? WHERE id=?");
        ps.setString(1, stato);
        ps.setInt(2, id);
        ps.executeUpdate();
    }

    public void elimina(int id) throws Exception {
        Connection c = DBConnection.getInstance().getConnection();
        PreparedStatement ps = c.prepareStatement("DELETE FROM ordine WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public List<Ordine> getAll() throws Exception {
        List<Ordine> list = new ArrayList<>();
        Connection c = DBConnection.getInstance().getConnection();
        PizzaDAO pizzaDAO = new PizzaDAO();

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM ordine");

        while (rs.next()) {
            int pizzaId = rs.getInt("id_pizza");
            Pizza pizza = pizzaDAO.getPizzaById(pizzaId);
            String stato = rs.getString("stato");
            double prezzoTotale = rs.getDouble("prezzo_totale");

            list.add(new Ordine(rs.getInt("id"), pizza, stato, prezzoTotale));
        }

        return list;
    }
}
