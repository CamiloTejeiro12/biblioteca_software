package main;

import dataSource.DataSource;
import reportConsole.ReportConsole;
import reportGraphics.ReportGraphics;
import tableReport.TableReport;
import sensor.Sensor;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        
        ReportConsole informeConsola = new ReportConsole();
        ReportGraphics informeGrafica = new ReportGraphics();
        TableReport informeTabla = new TableReport();
        
        dataSource.addObserver(informeConsola);
        dataSource.addObserver(informeGrafica);
        dataSource.addObserver(informeTabla);
        
        Sensor sensor1 = new Sensor(dataSource,"Sensor1");
        sensor1.enviarDatosAleatorios();
    }
}