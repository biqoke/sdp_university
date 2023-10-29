class ClothingProduct implements Product {
    private String name;
    private ProductCharacteristic characteristics;

    public ClothingProduct(String name, double price, String description) {
        this.name = name;
        this.characteristics = new ProductCharacteristic(price, description);
    }

    public void display() {
        System.out.println("Displaying clothing product: " + name);
        System.out.println("Price: " + characteristics.getPrice() + "тг");
        System.out.println("Description: " + characteristics.getDescription());
    }
}

