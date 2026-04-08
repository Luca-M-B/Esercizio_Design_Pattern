package main;

import java.util.Scanner;

import classi.Ordine;
import decorators.*;
import pizze_base.*;
import singleton.GestoreOrdini;
import observers.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GestoreOrdini gestore = GestoreOrdini.getInstance();

        gestore.addObserver(new Cucina()); // observers per cambio stato
        gestore.addObserver(new Forno());
        gestore.addObserver(new Consegna());
        gestore.addObserver(new GestioneOrdineObserver());

        int scelta;

        Pizza pizzaCorrente = null;

        do {
            System.out.println("\n\tMENU");
            System.out.println("1. Ordina");
            System.out.println("2. Traccia ordine");
            System.out.println("3. Modifica ordine");
            System.out.println("4. Elimina ordine");
            System.out.println("5. Conferma ordine");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            scelta = scanner.nextInt();

            switch (scelta) {

                case 1:
                    pizzaCorrente = creaPizza(scanner);
                    System.out.println("Pizza creata (non confermata): "
                            + pizzaCorrente.getDescrizione() +
                            " | Prezzo: " + pizzaCorrente.getPrezzo());
                    break;

                case 2:
                    System.out.println("Inserisci numero ordine:");
                    int numeroTrack = scanner.nextInt();
                    Ordine ordineTrack = gestore.getOrdineById(numeroTrack);

                    if (ordineTrack != null) {
                        System.out.println(ordineTrack);
                    } else {
                        System.out.println("Ordine non trovato");
                    }
                    break;

                case 3:
                    System.out.println("Inserisci numero ordine da modificare:");
                    int numeroModifica = scanner.nextInt();
                    Ordine ordineModifica = gestore.getOrdineById(numeroModifica);

                    if (ordineModifica != null && ordineModifica.getStato().equals("CREATO")) {

                        Pizza nuovaPizza = creaPizza(scanner);
                        ordineModifica.setPizza(nuovaPizza);

                        System.out.println("Ordine modificato: " + ordineModifica);

                    } else {
                        System.out.println("Modifica non consentita");
                    }
                    break;

                case 4:
                    System.out.println("Inserisci numero ordine da eliminare:");
                    int numeroElimina = scanner.nextInt();
                    Ordine ordineElimina = gestore.getOrdineById(numeroElimina);

                    if (ordineElimina != null && ordineElimina.getStato().equals("CREATO")) {
                        gestore.getOrdini().remove(ordineElimina);
                        System.out.println("Ordine eliminato");
                    } else {
                        System.out.println("Eliminazione non consentita");
                    }
                    break;

                case 5:

                    if (pizzaCorrente != null) {
                        Ordine ordine = new Ordine(pizzaCorrente);
                        gestore.aggiungiOrdine(ordine);

                        gestore.aggiornaStato(ordine.getId(), "CREATO");

                        System.out.println("Ordine confermato: " + ordine);

                        pizzaCorrente = null; // reset
                    } else {
                        System.out.println("Nessuna pizza da confermare");
                    }

                    break;

                case 0:
                    System.out.println("Chiusura");
                    break;

                default:
                    System.out.println("Scelta non valida");
            }

        } while (scelta != 0);

        scanner.close();
    }

    private static Pizza creaPizza(Scanner scanner) {

        Pizza pizza = null;
        int sceltaBase;

        do {
            System.out.println("\nScegli la base:");
            System.out.println("1. Base rossa");
            System.out.println("2. Base bianca");
            System.out.println("3. Margherita");
            System.out.print("Scelta: ");

            sceltaBase = scanner.nextInt();

            switch (sceltaBase) {
                case 1:
                    pizza = new BaseRossa();
                    break;
                case 2:
                    pizza = new BaseBianca();
                    break;
                case 3:
                    pizza = new Margherita();
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        } while (pizza == null);

        int sceltaExtra;

        do {
            System.out.println("\nAggiungi ingredienti:");
            System.out.println("1. Salame");
            System.out.println("2. Salame Piccante");
            System.out.println("3. Funghi");
            System.out.println("4. Prosciutto Crudo");
            System.out.println("5. Mozzarella");
            System.out.println("0. Fine");

            sceltaExtra = scanner.nextInt();

            switch (sceltaExtra) {
                case 1:
                    pizza = new Salame(pizza);
                    break;
                case 2:
                    pizza = new SalamePiccante(pizza);
                    break;
                case 3:
                    pizza = new Funghi(pizza);
                    break;
                case 4:
                    pizza = new ProsciuttoCrudo(pizza);
                    break;
                case 5:
                    pizza = new Mozzarella(pizza);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }

        } while (sceltaExtra != 0);

        return pizza;
    }
}