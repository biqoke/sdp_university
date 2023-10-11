public class MilkDecorator implements CoffeeDecorator {
    private Coffee coffee;

    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription() + " + Milk"; // Add "Milk" to the description
    }

    public double cost() {
        return coffee.cost() + 100; // Add the cost of "Milk"
    }
}
