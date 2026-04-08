package decorators;

public abstract class PizzaDecorator implements Pizza {

    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
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
