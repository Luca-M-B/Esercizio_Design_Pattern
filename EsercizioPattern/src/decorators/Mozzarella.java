package decorators;

import pizze_base.Pizza;

public class Mozzarella extends PizzaDecorator {

    public Mozzarella(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescrizione() {
        return pizza.getDescrizione() + ", mozzarella extra";
    }

    @Override
    public double getPrezzo() {
        return pizza.getPrezzo() + 1.50;
    }

}
