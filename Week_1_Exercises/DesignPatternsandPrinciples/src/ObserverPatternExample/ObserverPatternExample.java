package ObserverPatternExample;

import java.util.ArrayList;
import java.util.List;

// Subject Interface
interface StockSubject {
    void registerObserver(StockObserver observer);

    void deregisterObserver(StockObserver observer);

    void notifyObservers();
}

// Concrete Subject
class StockMarketSubject implements StockSubject {
    private List<StockObserver> observersList = new ArrayList<>();
    private String stockSymbol;
    private double price;

    public StockMarketSubject(String stockSymbol, double price) {
        this.stockSymbol = stockSymbol;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void registerObserver(StockObserver observer) {
        observersList.add(observer);
    }

    @Override
    public void deregisterObserver(StockObserver observer) {
        observersList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (StockObserver observer : observersList) {
            observer.update(stockSymbol, price);
        }
    }
}

// Observer Interface
interface StockObserver {
    void update(String stockSymbol, double price);
}

// Concrete Observer - Mobile App
class MobileStockObserver implements StockObserver {
    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Mobile App Notification: " + stockSymbol + " is now $" + price);
    }
}

// Concrete Observer - Web App
class WebStockObserver implements StockObserver {
    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Web App Notification: " + stockSymbol + " is now $" + price);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarketSubject stockMarket = new StockMarketSubject("ABC Corp", 100.0);

        StockObserver mobileObserver = new MobileStockObserver();
        StockObserver webObserver = new WebStockObserver();

        stockMarket.registerObserver(mobileObserver);
        stockMarket.registerObserver(webObserver);

        stockMarket.setPrice(105.0);
        stockMarket.setPrice(110.0);
    }
}
