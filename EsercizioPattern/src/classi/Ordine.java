package classi;

import pizze_base.Pizza;

public class Ordine {

    private int id;
    private Pizza pizza;
    private String stato; // TODO temporaneo (in attesa dell'enum condiviso)
    private double prezzoTotale;

    // Costruttore per nuovo ordine (senza ID DB)
    public Ordine(Pizza pizza) {
        this.pizza = pizza;
        this.stato = "CREATO";
        this.prezzoTotale = pizza.getPrezzo();
    }

    // Costruttore per ordine già esistente nel DB
    public Ordine(int id, Pizza pizza, String stato, double prezzoTotale) {
        this.id = id;
        this.pizza = pizza;
        this.stato = stato;
        this.prezzoTotale = prezzoTotale;
    }

    public int getId() {
        return id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "ID Ordine " + id + " | "
                + pizza.getDescrizione() +
                " | Prezzo: " + prezzoTotale +
                " | Stato: " + stato;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

}