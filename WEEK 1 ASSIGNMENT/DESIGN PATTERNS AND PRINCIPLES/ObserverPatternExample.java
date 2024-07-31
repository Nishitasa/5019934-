
import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp");
        Observer webApp = new WebApp("WebApp");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setPrice(100.50);
        stockMarket.setPrice(102.75);

        stockMarket.removeObserver(mobileApp);
        stockMarket.setPrice(105.00);
    }
}

interface Stock {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers;
    private double price;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
}

interface Observer {
    void update(double price);
}

class MobileApp implements Observer {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(double price) {
        System.out.println(appName + " received price update: " + price);
    }
}

class WebApp implements Observer {
    private String appName;

    public WebApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(double price) {
        System.out.println(appName + " received price update: " + price);
    }
}
