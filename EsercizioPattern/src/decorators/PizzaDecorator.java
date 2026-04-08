package decorators;

import pizze_base.Pizza;

public abstract class PizzaDecorator implements Pizza {

    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    protected String getNomeIngrediente() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String getDescrizione() {
        return pizza.getDescrizione();
    }

    @Override
    public double getPrezzo() {
        return pizza.getPrezzo();
    }

}
