package decorators;

import pizze_base.Pizza;

public class Funghi extends PizzaDecorator {

    private static final double PREZZO = 1.5;

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
