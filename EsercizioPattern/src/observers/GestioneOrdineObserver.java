package observers;

public class GestioneOrdineObserver implements Observer {

    @Override
    public void aggiorna(String stato) {
        if (stato.equals("CREATO")) {
            System.out.println("ordine confermato e preso in carico");
        }
    }

}
