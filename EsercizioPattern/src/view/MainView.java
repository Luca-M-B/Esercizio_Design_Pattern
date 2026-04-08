package view;

public class MainView {

    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void showMainMenuUser(){
            System.out.println("\n=== MENU PRINCIPALE ===");
            System.out.println("1) Ordina pizza");
            System.out.println("2) Traccia ordine");
            System.out.println("3) Modifica ordine");
            System.out.println("4) Elimina ordine");
            System.out.println("0) Esci");
            System.out.println("=======================");
    }

    public void showMainMenuAdmin(){
        System.out.println("\n=== MENU PRINCIPALE ===");
        System.out.println("1) Traccia ordine");
        System.out.println("2) Gestione pizze");
        System.out.println("3) Gestione ordini");
        System.out.println("0. Esci");
        System.out.println("=======================");
    }

    public void showMenuIngredients(){
        System.out.println("\n=== Aggiungi ingredienti ===");
        System.out.println("1) Mozzarella");
        System.out.println("2) Funghi");
        System.out.println("3) Salame");
        System.out.println("4) Prosciutto");
        System.out.println("5) Fine aggiunta ingredienti");
        System.out.println("6) Annulla ordine");
        System.out.println("============================");
    }
}