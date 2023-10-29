class Customer implements ShopObserver {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received a notification: " + message);
    }
}
