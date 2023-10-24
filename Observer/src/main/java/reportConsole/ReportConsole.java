package reportConsole;

import observer.Observer;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ReportConsole implements Observer {
    private JFrame frame;
    private JTextArea textArea;

    public ReportConsole() {
        frame = new JFrame("Informe de Sensor");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea(10, 40);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    @Override
    public void update(String nameSensor, double co2, double no2, double opacimetro, double anemotro, double luxometro) {
        String informe = "Informe en Consola para el sensor " + nameSensor + ":\n" +
                        "CO2: " + co2 + "\n" +
                        "NO2: " + no2 + "\n" +
                        "Opacímetro: " + opacimetro + "\n" +
                        "Anemómetro: " + anemotro + "\n" +
                        "Luxómetro: " + luxometro + "\n\n";

        textArea.append(informe);
    }
}


