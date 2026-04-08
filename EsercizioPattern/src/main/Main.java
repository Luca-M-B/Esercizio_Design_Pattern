package main;

import java.util.Scanner;

import classi.Ordine;
import pizze_base.Pizza;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Pizza pizza = null;

        System.out.println("1. Base rossa\n 2. Base bianca\n 3. Margherita");
        int scelta = scanner.nextInt();

        switch (scelta) {
            case 1:
            case 2:
            case 3:
            default:
                System.out.println("scegli una opzione valida");
                break;
        }

        Ordine ordine = new Ordine(pizza);
        // aspetto per chiamare i metodi aggiungiObserver
        /*
         * ordine.aggiungiObserver(new Cucina());
         * ordine.aggiungiObserver(new Forno());
         * ordine.aggiungiObserver(new Consegna());
         */

        /*
         * // Singleton
         * GestoreOrdini gestore = GestoreOrdini.getInstance();
         * gestore.aggiungiOrdine(ordine);
         */

        /*
         * // Cambia stati
         * ordine.setStato("IN PREPARAZIONE");
         * ordine.setStato("IN COTTURA");
         * ordine.setStato("PRONTO");
         */

        scanner.close();
    }

}
