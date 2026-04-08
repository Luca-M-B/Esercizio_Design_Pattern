package observers;

import classi.Ordine;

public class Cucina implements Observer {
    @Override
    public void aggiorna(Ordine ordine) {
        System.out.println("[CUCINA] Ordine #" + ordine.getId() + " aggiornato a stato: " + ordine.getStato());
    }
}