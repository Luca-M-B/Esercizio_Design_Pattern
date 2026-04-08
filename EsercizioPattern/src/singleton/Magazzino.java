package singleton;
public class Magazzino {

    private static Magazzino instance;

    private int mozzarella = 5; //inserisco gli ingredienti e la quantità
    private int salame = 4;
    private int funghi = 3;
    private int prosciuttocrudo = 6;
    private int olive = 3;

    private Magazzino() {}

    public static Magazzino getInstance() {
        if (instance == null) {
            instance = new Magazzino();
        }
        return instance;
    }

    public boolean disponibile(String ingrediente) { //metto la condizione che sia maggiore di 0 per la disponibilità
        switch (ingrediente.toLowerCase()) {
            case "mozzarella":
                return mozzarella > 0;
            case "salame":
                return salame > 0;
            case "funghi":
                return funghi > 0;
            case "prosciuttocrudo":
                return prosciuttocrudo > 0;
            case "olive":
                return olive > 0;
            default:
                return false;
        }
    }

    public boolean consumaIngrediente(String ingrediente) {
        if (!disponibile(ingrediente)) {
            return false;
        }

        switch (ingrediente.toLowerCase()) { //ogni volta che aggiungo un ingrediente lo tolgo dal magazzino finchè la disponibilità è 0
            case "mozzarella":
                mozzarella--;
                break;
            case "salame":
                salame--;
                break;
            case "funghi":
                funghi--;
                break;
            case "prosciuttocrudo":
                prosciuttocrudo--;
                break;
            case "olive":
                olive--;
                break;
        }
        return true;
    }

    public void stampaDisponibilita() { //stampa disponibilità
        System.out.println("--- MAGAZZINO ---");
        System.out.println("Mozzarella extra: " + mozzarella);
        System.out.println("Salame: " + salame);
        System.out.println("Funghi: " + funghi);
        System.out.println("Prosciutto crudo: " + prosciuttocrudo);
        System.out.println("Olive: " + olive);
    }
}