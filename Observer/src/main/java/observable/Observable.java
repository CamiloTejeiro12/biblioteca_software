package observable;

import observer.Observer;

public interface Observable {
    void addObserver(Observer o);
    
    void deleteObserver(Observer o);
    
    void notifyObservers(String nameSensor, double co2, double no2, double opacimetro, double anemotro, double luxometro);  
}