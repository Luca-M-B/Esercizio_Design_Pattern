package decorators;

import pizze_base.Pizza;

public class ProsciuttoCrudo extends PizzaDecorator {

    public ProsciuttoCrudo(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescrizione() {
        return pizza.getDescrizione() + ", prosciutto crudo";
    }

    @Override
    public double getPrezzo() {
        return pizza.getPrezzo() + 1.50;
    }

}
