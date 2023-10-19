package conexioDataBase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionBD {
    private Connection conexion;
    private static ConexionBD instancia;

    private ConexionBD() {
        // Constructor privado para evitar la creación de instancias desde fuera de la clase
    }

    public static ConexionBD obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public Connection conectar() {
        if (conexion != null) {
            return conexion; // Si ya está conectado, devuelve la conexión existente
        }

        Properties propiedades = new Properties();
        try {
            // Cargar el archivo de propiedades desde el classpath
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            propiedades.load(classLoader.getResourceAsStream("config/configDataBase.properties"));

            String host = propiedades.getProperty("db.host");
            String port = propiedades.getProperty("db.port");
            String database = propiedades.getProperty("db.database");
            String user = propiedades.getProperty("db.user");
            String password = propiedades.getProperty("db.password");
            String engine = propiedades.getProperty("db.engine");

            String url = "jdbc:" + engine + "://" + host + ":" + port + "/" + database;

            try {
                // Establecer la conexión
                conexion = DriverManager.getConnection(url, user, password);
                return conexion;
            } catch (SQLException e) {
                System.err.println("Error de SQL al conectar a la base de datos: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de propiedades: " + e.getMessage());
        }
        return null;
    }

    public void desconectar() {
        if (conexion != null) {
            try {
                conexion.close();
                conexion = null;
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
