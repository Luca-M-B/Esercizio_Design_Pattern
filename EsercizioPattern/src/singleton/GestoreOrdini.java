package singleton;

import java.util.ArrayList;

import pizze_base.Pizza;

public class GestoreOrdini {

    private static GestoreOrdini istance;

    private ArrayList<Pizza> ordini;

    private GestoreOrdini() {
        ordini = new ArrayList<>();
    }

    public static GestoreOrdini getIstance() {
        if (istance == null) {
            istance = new GestoreOrdini();
        }
        return istance;
    }

    public void aggiungiOrdine(Pizza pizza) {
        ordini.add(pizza);
    }

    public ArrayList<Pizza> getOrdini() {
        return ordini;
    }

}
