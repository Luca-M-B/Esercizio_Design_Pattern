package decorators;

import pizze_base.Pizza;

public class Mozzarella extends PizzaDecorator {

    private String nome = "Mozzarella";

    private double prezzo = 1.50;

    public Mozzarella(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescrizione() {
        return pizza.getDescrizione() + ", mozzarella extra";
    }

    @Override
    public double getPrezzo() {
        return pizza.getPrezzo() + prezzo;
    }

}
