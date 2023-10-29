import java.util.ArrayList;
import java.util.List;

class PromotionManager {
    private List<ShopObserver> subscribers = new ArrayList<>();

    public void subscribe(ShopObserver subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(ShopObserver subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String message) {
        for (ShopObserver subscriber : subscribers) {
            subscriber.update(message);
        }
    }

    public void createPromotion(String promotionMessage) {
        System.out.println("Promotion created: " + promotionMessage);
        notifySubscribers(promotionMessage);
    }
}
