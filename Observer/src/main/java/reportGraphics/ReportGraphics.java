package reportGraphics;


public class ReportGraphics implements Observer {
    @Override
    public void update(String nameSensor, double co2, double no2, double opacimetro, double anemotro, double luxometro){
        System.out.println("Informe en grafica: " + nameSensor);
    }
}
