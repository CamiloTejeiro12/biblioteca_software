package tableReport;

import observer.Observer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableReport extends JFrame implements Observer {
    private DefaultTableModel tableModel;
    private JTable table;

    public TableReport() {
        super("Sensor Data Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Sensor Name");
        tableModel.addColumn("CO2");
        tableModel.addColumn("NO2");
        tableModel.addColumn("Opacimetro");
        tableModel.addColumn("Anemotro");
        tableModel.addColumn("Luxometro");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(String nameSensor, double co2, double no2, double opacimetro, double anemotro, double luxometro) {
        // Agregar una nueva fila con los datos recibidos
        tableModel.addRow(new Object[]{nameSensor, co2, no2, opacimetro, anemotro, luxometro});
    }
}

