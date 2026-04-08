package decorators;

public class BaseBianca implements Pizza {

    @Override
    public String getDescrizione() {
        return "Pizza base bianca";
    }

    @Override
    public double getPrezzo() {
        return 4.0;
    }
}