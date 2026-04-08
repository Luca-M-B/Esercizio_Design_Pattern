package controller;

import java.util.List;

import service.PizzaBaseDAO;
import utility.Utility;

public class PizzaBaseController {
    PizzaBaseDAO pizzaBaseDAO = new PizzaBaseDAO();

    public void aggiungiPizza() throws Exception {
        System.out.print("Nome pizza: ");
        String nome = Utility.askString();

        System.out.print("Prezzo base: ");
        double prezzo = Utility.askDouble();

        pizzaBaseDAO.createPizzaBase(nome, prezzo);
        System.out.println("Pizza aggiunta!");
    }

    public void visualizzaPizze() throws Exception {
        List<String> pizze = pizzaBaseDAO.getAllPizzeBase();
        pizze.forEach(System.out::println);
    }

    public void modificaPizza() throws Exception {
        System.out.print("ID pizza da modificare: ");
        int id = Utility.askInt();

        System.out.print("Nuovo nome: ");
        String nome = Utility.askString();

        System.out.print("Nuovo prezzo: ");
        double prezzo = Utility.askDouble();

        pizzaBaseDAO.updatePizzaBase(id, nome, prezzo);
        System.out.println("Pizza modificata!");
    }

    public void rimuoviPizza() throws Exception {
        System.out.print("ID pizza da rimuovere: ");
        int id = Utility.askInt();

        pizzaBaseDAO.deletePizzaBase(id);
        System.out.println("Pizza rimossa!");
    }
}
