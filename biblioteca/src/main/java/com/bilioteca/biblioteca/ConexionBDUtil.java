/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilioteca.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBDUtil {

    private static Connection conexion = null;

    // Método para establecer la conexión a la base de datos
    public static Connection obtenerConexion() {
        if (conexion == null) {
            String url = "jdbc:postgresql://localhost:5432/biblioteca";
            String usuario = "jhon";
            String contraseña = "123456";

            try {
                conexion = DriverManager.getConnection(url, usuario, contraseña);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conexion;
    }

    // Método para cerrar la conexión
    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
