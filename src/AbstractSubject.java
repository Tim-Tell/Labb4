import java.util.ArrayList;
import java.util.List;

// Abstrakt basimplementering av Subject
public abstract class AbstractSubject<T extends Observer> implements Subject {
    private List<T> observers = new ArrayList<>();

    @Override
    public void addObserver(T observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(T observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (T observer : observers) {
            observer.update();
        }
    }
}
