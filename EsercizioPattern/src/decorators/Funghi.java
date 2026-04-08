package decorators;

public class Funghi extends PizzaDecorator {

    public Funghi(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescrizione() {
        return pizza.getDescrizione() + ", funghi";
    }

    @Override
    public double getPrezzo() {
        return pizza.getPrezzo() + 1.5;
    }

}
