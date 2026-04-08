package controller;

import java.util.ArrayList;
import java.util.List;

import classi.Ordine;
import decorators.*;
import pizze_base.*;
import service.OrderDAO;
import utility.Utility;
import view.MainView;

public class OrderController {

    public void ordinaPizza() throws Exception {
        MainView view = new MainView();
        OrderDAO orderDAO = new OrderDAO();
        PizzaController pizzaController = new PizzaController();
        List<String> ingredienti = new ArrayList<>();
        
        Pizza base;
        
        while (true) {
            System.out.println("Scegli la base della pizza:");
            System.out.println("1) Base bianca");
            System.out.println("2) Base rossa");
            System.out.println("0) Annulla ordine");

            System.out.print("Scelta: ");
            int baseChoice = Utility.askInt();

            switch(baseChoice) {
                case 1 -> base = new BaseBianca();
                case 2 -> base = new BaseRossa();
                default -> throw new IllegalArgumentException("Scelta non valida");
            }

            if (base != null) {
                // Ciclo per aggiungere ingredienti finché il cliente non decide di terminare (inserendo 0)
                while(true) {

                    view.showMenuIngredients();
                    
                    view.print("Scelta ingrediente (5 per terminare, 0 per annullare): ");
                    int ing = Utility.askInt();

                    if(ing == 0) break;

                    String nomeIng = switch (ing) {
                        case 1 -> "Mozzarella";
                        case 2 -> "Funghi";
                        case 3 -> "Salame";
                        case 4 -> "SalamePiccante";
                        case 5 -> "ProsciuttoCrudo";
                        default -> "";
                    };
                    if (!nomeIng.isEmpty()) ingredienti.add(nomeIng);
                    
                    switch(ing) {
                        case 1 -> base = new Mozzarella(base);
                        case 2 -> base = new Funghi(base);
                        case 3 -> base = new Salame(base);
                        case 4 -> base = new SalamePiccante(base);
                        case 5 -> base = new ProsciuttoCrudo(base);
                        // esci dal ciclo se il cliente ha finito di aggiungere ingredienti
                        case 9 -> {
                            System.out.println("Creando l'ordine...");
                            break;
                        }
                        case 0 -> {
                            System.out.println("Ordine annullato.");
                            return; // esce dal metodo, annullando l'ordine
                        }
                    }
                    System.out.println("Prezzo totale: " + base.getPrezzo());
                    // qui si potrebbe anche mostrare un riepilogo degli ingredienti scelti, se si volesse, è chiedere se si è sicuri dell'ordine prima di crearlo
                    orderDAO.creaOrdine(pizzaController.aggiungiPizza(baseChoice, ingredienti));
                    return; // esce dal metodo dopo aver creato l'ordine
                }
            }
        }
    }
    
    public void tracciaOrdine() throws Exception {
        OrderDAO orderDAO = new OrderDAO();

        System.out.print("ID ordine: ");
        int id = Utility.askInt();
        
        Ordine o = orderDAO.getOrdine(id);
        if(o != null) System.out.println("Stato: " + o.getStato() + " Prezzo: " + o.getPrezzoTotale());

        else System.out.println("Ordine non trovato");
    }

    public void modificaOrdine() throws Exception {
        OrderDAO orderDAO = new OrderDAO();

        System.out.print("ID ordine: "); int id = Utility.askInt();
        System.out.print("Nuovo stato: "); String stato = Utility.askString();
        orderDAO.aggiornaStato(id, stato);
    }

    public void eliminaOrdine() throws Exception {
        OrderDAO orderDAO = new OrderDAO();

        System.out.print("ID ordine: "); int id = Utility.askInt();
        orderDAO.elimina(id);
    }

}