class FoodProduct implements Product {
    private String name;
    private ProductCharacteristic characteristics;

    public FoodProduct(String name, double price, String description) {
        this.name = name;
        this.characteristics = new ProductCharacteristic(price, description);
    }

    public void display() {
        System.out.println("Displaying food product: " + name);
        System.out.println("Price: " + characteristics.getPrice() + "тг");
        System.out.println("Description: " + characteristics.getDescription());
    }
}
