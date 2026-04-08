package classi;

import pizze_base.Pizza;

public class Ordine {

    private static int counter = 0;

    private int id;
    private Pizza pizza;
    private String stato; // temporaneo (in attesa dell'enum condiviso)

    public Ordine(Pizza pizza) {
        this.id = ++counter;
        this.pizza = pizza;
        this.stato = "CREATO";
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
                " | Prezzo: " + pizza.getPrezzo() +
                " | Stato: " + stato;
    }
}