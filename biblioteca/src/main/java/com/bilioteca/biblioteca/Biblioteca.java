package com.bilioteca.biblioteca;

import com.bilioteca.libro.Editorial;
import com.bilioteca.libro.LibroFisico;
import com.bilioteca.libro.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.bilioteca.libro.LibroVirtual; // Asegúrate de importar la clase LibroVirtual



public class Biblioteca {

    public static void main(String[] args) {
        try (Connection conexion = ConexionBDUtil.obtenerConexion()) {
            LibroVirtual libroVirtualExistente = obtenerLibroVirtualExistente(conexion);
            LibroFisico libroFisicoExistente = obtenerLibroFisicoExistente(conexion);
            Editorial editorialExistente = obtenerEditorialExistente(conexion);
            Categoria categoriaExistente = obtenerCategoriaExistente(conexion);

            Libro nuevoLibro = new Libro(
                UUID.randomUUID(),              // 1. Generar un nuevo ID para el libro
                "Título del Nuevo Libro",     // 2. Título del nuevo libro
                "Este libro es buenisimo",
                "Autor del Nuevo Libro",       // 3. Autor del nuevo libro
                "ISBN123456789",               // 4. Número ISBN del nuevo libro
                "Disponible",                  // 5. Estado de disponibilidad del libro
                5,                             // 6. Número total de copias del libro
                libroVirtualExistente,         // 7. UUID existente de libro virtual
                libroFisicoExistente,             // 8. Generar un nuevo ID de libro físico
                editorialExistente,             // 9. Generar un nuevo ID de editorial
                categoriaExistente              // 10. Generar un nuevo ID de categoría
            );

            nuevoLibro.insertarEnBaseDeDatos(conexion);
            System.out.println("Nuevo libro insertado en la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public static LibroVirtual obtenerLibroVirtualExistente(Connection conexion) throws SQLException {
    String consultaSQL = "SELECT id, marcado_usuario, formato_electronico, resumen, tamano_archivo FROM libro_virtual LIMIT 1"; // Explicitly select the "titulo" column
    try (PreparedStatement statement = conexion.prepareStatement(consultaSQL);
         ResultSet resultSet = statement.executeQuery()) {
        if (resultSet.next()) {
            // Construye un objeto LibroVirtual a partir de los datos obtenidos de la consulta
            UUID id = UUID.fromString(resultSet.getString("id"));
            String marcadoUsuario = resultSet.getString("marcado_usuario");
            String formatoElectronico = resultSet.getString("formato_electronico");
            String resumen = resultSet.getString("resumen");
            String tamanoArchivo = resultSet.getString("tamano_archivo");

            // Crea y devuelve un objeto LibroVirtual existente
            return new LibroVirtual(id, marcadoUsuario, formatoElectronico, resumen, tamanoArchivo);
        } else {
            throw new SQLException("No se encontraron registros en la tabla libro_virtual.");
        }
}
    }
        public static LibroFisico obtenerLibroFisicoExistente(Connection conexion) throws SQLException {
            String consultaSQL = "SELECT id, ubicacion, estado FROM libro_fisico LIMIT 1"; // Consulta SQL para obtener un libro físico existente
            try (PreparedStatement statement = conexion.prepareStatement(consultaSQL);
                 ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Obtén los datos del libro físico desde el resultado de la consulta
                    UUID id = UUID.fromString(resultSet.getString("id"));
                    String ubicacion = resultSet.getString("ubicacion");
                    String estado = resultSet.getString("estado");

                    // Crea y devuelve un objeto LibroFisico existente
                    return new LibroFisico(id, ubicacion, estado);
                } else {
                    throw new SQLException("No se encontraron registros en la tabla libro_fisico.");
                }
            }
        }
        
        
public static Editorial obtenerEditorialExistente(Connection conexion) throws SQLException {
    String consultaSQL = "SELECT id, nombre FROM editorial LIMIT 1"; // Consulta SQL para obtener una editorial existente
    try (PreparedStatement statement = conexion.prepareStatement(consultaSQL);
         ResultSet resultSet = statement.executeQuery()) {
        if (resultSet.next()) {
            // Obtén los datos de la editorial desde el resultado de la consulta
            UUID id = UUID.fromString(resultSet.getString("id"));
            String nombre = resultSet.getString("nombre");

            // Crea y devuelve un objeto Editorial existente
            return new Editorial(id, nombre);
        } else {
            throw new SQLException("No se encontraron registros en la tabla editorial.");
        }
    }
}

public static Categoria obtenerCategoriaExistente(Connection conexion) throws SQLException {
    String consultaSQL = "SELECT id, descripcion FROM categoria "; // Consulta SQL para obtener una categoría existente
    try (PreparedStatement statement = conexion.prepareStatement(consultaSQL);
         ResultSet resultSet = statement.executeQuery()) {
        if (resultSet.next()) {
            // Obtén los datos de la categoría desde el resultado de la consulta
            UUID id = UUID.fromString(resultSet.getString("id"));
            String descripcion = resultSet.getString("descripcion");

            // Crea y devuelve un objeto Categoria existente
            return new Categoria(id, descripcion);
        } else {
            throw new SQLException("No se encontraron registros en la tabla categoria.");
        }
    }
}



    // Función para obtener un UUID existente de la tabla libro_virtual
    public static UUID obtenerUUIDExistenteDeLibroVirtual(Connection conexion) throws SQLException {
        String consultaSQL = "SELECT id FROM libro_virtual LIMIT 1"; // 11. Consulta SQL para obtener un UUID de un registro existente
        try (PreparedStatement statement = conexion.prepareStatement(consultaSQL);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return UUID.fromString(resultSet.getString("id")); // 12. Devolver el UUID obtenido
            } else {
                throw new SQLException("No se encontraron registros en la tabla libro_virtual.");
            }
        }
    }
}
