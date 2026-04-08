package observers;

public class Cucina implements Observer {
    public void aggiorna(String stato) {
        if (stato.equals("IN PREPARAZIONE")) {
            System.out.println("preparazione iniziata");
        }
    }
}