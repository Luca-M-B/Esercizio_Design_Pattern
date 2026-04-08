package pizze_base;

public class BaseRossa implements Pizza {

    @Override
    public String getDescrizione() {
        return "Pizza base rossa";
    }

    @Override
    public double getPrezzo() {
        return 4.50;
    }
}