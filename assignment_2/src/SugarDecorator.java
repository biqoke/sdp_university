public class SugarDecorator implements CoffeeDecorator {
    private Coffee coffee;

    public SugarDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription() + " + Sugar"; // Add "Sugar" to the description
    }

    public double cost() {
        return coffee.cost() + 100; // Add the cost of "Sugar"
    }
}