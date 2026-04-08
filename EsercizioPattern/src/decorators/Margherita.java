package decorators;

public class Margherita implements Pizza { // classe concreta margherita

    @Override
    public String getDescrizione() {
        return "Pizza base Margherita";
    }

    @Override
    public double getPrezzo() {
        return 7.00;
    }
}
