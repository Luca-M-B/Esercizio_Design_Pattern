package decorators;

import pizze_base.Pizza;

public class Salame extends PizzaDecorator {

    private static final double PREZZO = 2.0;

    public Salame(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescrizione() {
        return pizza.getDescrizione() + ", salame";
    }

    @Override
    public double getPrezzo() {
        return pizza.getPrezzo() + 2.0;
    }

}
