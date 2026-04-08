package decorators;

import pizze_base.Pizza;

public class SalamePiccante extends PizzaDecorator {

    public SalamePiccante(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescrizione() {
        return pizza.getDescrizione() + ", salame piccante";
    }

    @Override
    public double getPrezzo() {
        return pizza.getPrezzo() + 2.50;
    }

}
