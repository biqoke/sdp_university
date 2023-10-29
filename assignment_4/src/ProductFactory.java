import java.util.HashMap;
import java.util.Map;

class ProductFactory {
    private Map<String, ProductFactoryMethod> factories = new HashMap<>();

    public interface ProductFactoryMethod {
        Product createProduct(String name, double price, String description);
    }

    public void registerFactory(String type, ProductFactoryMethod factory) {
        factories.put(type, factory);
    }

    public Product createProduct(String type, String name, double price, String description) {
        if (factories.containsKey(type)) {
            return factories.get(type).createProduct(name, price, description);
        }
        return null;
    }
}
