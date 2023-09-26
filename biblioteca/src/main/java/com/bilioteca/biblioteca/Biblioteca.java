package com.bilioteca.biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Biblioteca {

    public static void main(String[] args) {
        // Obtener una conexión a la base de datos
        try (Connection conexion = ConexionBDUtil.obtenerConexion()) {
            // Obtener un UUID válido de libro_virtual
            UUID libroVirtualExistente = obtenerUUIDExistenteDeLibroVirtual(conexion);

            // Crear un nuevo libro y realizar operaciones
            Libro nuevoLibro = new Libro(
                    UUID.randomUUID(), // Generar un nuevo ID
                    "Título del Nuevo Libro",
                    "Autor del Nuevo Libro",
                    "ISBN123456789",
                    "Disponible",
                    5, // Copias totales
                    libroVirtualExistente, // Utilizar el UUID existente de libro_virtual
                    UUID.randomUUID(), // ID de libro físico
                    UUID.randomUUID(), // ID de editorial
                    UUID.randomUUID() // ID de categoría
            );

            nuevoLibro.insertarEnBaseDeDatos(conexion);
            System.out.println("Nuevo libro insertado en la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Esta función obtiene un UUID existente de la tabla libro_virtual
    public static UUID obtenerUUIDExistenteDeLibroVirtual(Connection conexion) throws SQLException {
        String consultaSQL = "SELECT id FROM libro_virtual LIMIT 1"; // Obtener un UUID de un registro existente
        try (PreparedStatement statement = conexion.prepareStatement(consultaSQL);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return UUID.fromString(resultSet.getString("id"));
            } else {
                throw new SQLException("No se encontraron registros en la tabla libro_virtual.");
            }
        }
    }
}
