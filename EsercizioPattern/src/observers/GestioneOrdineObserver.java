package observers;

import classi.Ordine;

public class GestioneOrdineObserver implements Observer {

    @Override
    public void aggiorna(Ordine ordine) {
        if (ordine.getStato().equalsIgnoreCase("CREATO")) {
            System.out.println("ordine confermato e preso in carico");
        }
    }

}
