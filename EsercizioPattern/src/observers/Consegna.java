package observers;

import classi.Ordine;

public class Consegna implements Observer {
    @Override
    public void aggiorna(Ordine ordine) {
        if(ordine.getStato().equalsIgnoreCase("IN_CONSEGNA")) {
            System.out.println("[CONSEGNA] Ordine #" + ordine.getId() + " pronto per la consegna!");
        }
    }
}