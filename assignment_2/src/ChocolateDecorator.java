public class ChocolateDecorator implements CoffeeDecorator {
    private Coffee coffee;

    public ChocolateDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription() + " + Chocolate"; // Add "Chocolate" to the description
    }

    public double cost() {
        return coffee.cost() + 200; // Add the cost of "Chocolate"
    }
}