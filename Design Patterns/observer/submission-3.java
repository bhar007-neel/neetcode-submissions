

interface Observer {
    void update();
}

class Customer implements Observer {
    private final String name;
    private int notifications;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        notifications++;
    }

    public int countNotifications() {
        return notifications;
    }
}

class OnlineStoreItem {
    private final String name;
    private int stock;
    private final Set<Observer> observers = new HashSet<>();

    public OnlineStoreItem(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void updateStock(int newStock) {
        boolean backInStock = stock == 0 && newStock > 0;
        stock = newStock;

        if (backInStock) {
            for (Observer observer : observers) {
                observer.update();
            }
        }
    }
}