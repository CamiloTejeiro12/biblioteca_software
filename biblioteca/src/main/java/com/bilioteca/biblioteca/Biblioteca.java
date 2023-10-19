package com.bilioteca.biblioteca;

import java.sql.Connection;
import conexioDataBase.ConexionBD;

public class Biblioteca {

    public static void main(String[] args) {
        ConexionBD conexionBD = ConexionBD.obtenerInstancia();
        Connection conexion = conexionBD.conectar();

        if (conexion != null) {
            // Realiza operaciones en la base de datos
            // Por ejemplo, ejecuta consultas SQL o realiza inserciones/actualizaciones
            // No olvides manejar excepciones en caso de errores SQL

            // Cierra la conexión cuando hayas terminado
            conexionBD.desconectar();
        } else {
            System.err.println("No se pudo conectar a la base de datos.");
        }
    }
}
