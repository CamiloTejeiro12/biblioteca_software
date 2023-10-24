package dataSource;

import observable.Observable;
import observer.Observer;
import java.util.HashSet;
import java.util.Set;

public class DataSource implements Observable{
    
    Set<Observer> observerSet = new HashSet<>();
    
    @Override
    public void addObserver(Observer o){
        observerSet.add(o);
    }
    
    @Override
    public void deleteObserver(Observer o){
        observerSet.remove(o);
    }
     
    @Override
    public void notifyObservers(String nameSensor, double co2, double no2, double opacimetro, double anemotro, double luxometro){
        for(Observer observer: observerSet){
            observer.update(nameSensor,co2,no2,opacimetro,anemotro,luxometro);
        }
    }
    public void receiveSensorData(String nameSensor, double co2, double no2, double opacimetro, double anemotro, double luxometro){
        notifyObservers(nameSensor,co2,no2,opacimetro,anemotro,luxometro);
    }
    
}