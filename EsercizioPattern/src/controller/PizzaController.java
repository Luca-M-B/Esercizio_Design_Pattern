package controller;

import service.PizzaDAO;
import utility.Utility;
import pizze_base.Pizza;

import java.util.List;

public class PizzaController {
    private final PizzaDAO pizzaDAO = new PizzaDAO();

    public int aggiungiPizza(int idBase, List<String> ingredienti) throws Exception {
        int idPizza = pizzaDAO.creaPizza(idBase, ingredienti);
        System.out.println("Pizza creata con ID: " + idPizza);
        return idPizza;
    }

    public void visualizzaPizze() throws Exception {
        List<Pizza> lista = pizzaDAO.getAllPizze();
        for (Pizza p : lista) {
            System.out.println(p.getDescrizione() + " | Prezzo: " + p.getPrezzo());
        }
    }

    public void cercaPizza() throws Exception {
        System.out.print("ID pizza: ");
        int id = Utility.askInt();

        Pizza p = pizzaDAO.getPizzaById(id);
        if (p != null) {
            System.out.println(p.getDescrizione() + " | Prezzo: " + p.getPrezzo());
        } else {
            System.out.println("Pizza non trovata");
        }
    }

    public void modificaPrezzoPizza() throws Exception {
        System.out.print("ID pizza: ");
        int id = Utility.askInt();

        System.out.print("Nuovo prezzo: ");
        double nuovoPrezzo = Utility.askDouble();

        pizzaDAO.aggiornaPrezzoTotale(id, nuovoPrezzo);
        System.out.println("Prezzo aggiornato!");
    }

    public void rimuoviPizza() throws Exception {
        System.out.print("ID pizza da rimuovere: ");
        int id = Utility.askInt();

        pizzaDAO.deletePizza(id);
        System.out.println("Pizza rimossa!");
    }
}