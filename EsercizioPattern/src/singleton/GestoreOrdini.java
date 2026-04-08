package singleton;

import java.util.ArrayList;

import classi.Ordine;

public class GestoreOrdini {

    private static GestoreOrdini istance;

    private ArrayList<Ordine> ordini;

    private GestoreOrdini() {
        ordini = new ArrayList<>();
    }

    public static GestoreOrdini getIstance() {
        if (istance == null) {
            istance = new GestoreOrdini();
        }
        return istance;
    }

    public void aggiungiOrdine(Ordine ordine) {
        ordini.add(ordine);
    }

    public ArrayList<Ordine> getOrdini() {
        return ordini;
    }

}
