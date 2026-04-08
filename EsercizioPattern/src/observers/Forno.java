package observers;

import classi.Ordine;

public class Forno implements Observer {

    @Override
    public void aggiorna(Ordine ordine) {
        if(ordine.getStato().equalsIgnoreCase("IN_FORNO")) {
            System.out.println("[FORNO] Pizza ordine #" + ordine.getId() + " è nel forno!");
        }
    }

}
