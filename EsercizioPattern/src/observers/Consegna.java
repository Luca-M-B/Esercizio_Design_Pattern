package observers;

public class Consegna implements Observer {

    public void aggiorna(String stato) {
        if (stato.equals("PRONTO")) {
            System.out.println("pizza pronta alla consegna");
        }
    }

}
