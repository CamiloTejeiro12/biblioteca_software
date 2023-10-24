package observer;


public interface Observer {

    void update(String nameSensor, double co2, double no2, double opacimetro, double anemotro, double luxometro);
    
}