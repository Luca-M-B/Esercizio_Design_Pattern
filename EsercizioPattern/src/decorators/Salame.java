package decorators;

public class Salame extends PizzaDecorator {

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
