package sensor;

import dataSource.DataSource;
import java.util.Random;

public class Sensor {
    private DataSource dataSource;
    private String nameSensor;

    public Sensor(DataSource dataSource, String nameSensor) {
        this.dataSource = dataSource;
        this.nameSensor = nameSensor;
    }

    public void enviarDatosAleatorios() {
        // Simulación de generación de datos aleatorios
        double co2 = generarDatoAleatorio();
        double no2 = generarDatoAleatorio();
        double opacimetro = generarDatoAleatorio();
        double anemotro = generarDatoAleatorio();
        double luxometro = generarDatoAleatorio();

        // Enviar datos al DataSource
        dataSource.receiveSensorData(nameSensor, co2, no2, opacimetro, anemotro, luxometro);
    }

    // Genera un valor aleatorio entre 0 y 100 para los diferentes datos
    private double generarDatoAleatorio() {
        return new Random().nextDouble() * 100;
    }
    
}
