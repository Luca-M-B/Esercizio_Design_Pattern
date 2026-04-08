package main;

import java.util.Scanner;

import classi.Ordine;
import pizze_base.BaseBianca;
import pizze_base.BaseRossa;
import pizze_base.Margherita;
import pizze_base.Pizza;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Pizza pizza = null;

        System.out.println("1. Base rossa\n 2. Base bianca\n 3. Margherita");
        int scelta = scanner.nextInt();

        switch (scelta) {
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




        /*  
        Main:

        Loop con menu:
         - Ordina pizza
         - Traccia ordine
         - Modifica ordine
         - Elimina ordine
         - Esci
        
         - Sotto menu per admin:
            - Menu pizze:
                - Aggiungi pizza
                - Visualizza pizze
                - Cerca pizza
                - Modifica pizza
                - Rimuovi pizza
                - Torna al menu admin
            - Menu ordini:
                - Visualizza ordini
                - Cerca ordine
                - Modifica ordine
                - Elimina ordine
                - Torna al main menu
        */

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
