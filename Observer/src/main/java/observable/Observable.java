package observable;

import observer.Observer;

public interface Observable {
    void addObserver(Observer o);
    
    void deleteObserver(Observer o);
    
    void notifyObservers();  
}
