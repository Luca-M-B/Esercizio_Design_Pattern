package observers;

public class Forno implements Observer {

    public void aggiorna(String stato) {
        if (stato.equals("IN COTTURA")) {
            System.out.println("pizza messa in cottura");
        }
    }

}
