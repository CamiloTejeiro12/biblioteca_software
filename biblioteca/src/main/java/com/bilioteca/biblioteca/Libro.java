package com.bilioteca.biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Clase para representar libros y realizar operaciones CRUD en la base de datos.
 */
public class Libro {

    private UUID id;
    private String titulo;
    private String autor;
    private String isbn;
    private String disponible;
    private int copiasTotales;
    private LibroVirtual libroVirtual;
    private LibroFisico libroFisico;
    private Editorial editorial;
    private Categoria categoria;

    public Libro(UUID id, String titulo, String autor, String isbn, String disponible, int copiasTotales,
            LibroVirtual libroVirtual, LibroFisico libroFisico, Editorial editorial, Categoria categoria) {
        // Agregar validaciones de entrada aquí (por ejemplo, para copiasTotales >= 0)
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = disponible;
        this.copiasTotales = copiasTotales;
        this.libroVirtual = libroVirtual;
        this.libroFisico = libroFisico;
        this.editorial = editorial;
        this.categoria = categoria;
    }

    // Métodos CRUD

    // Insertar un nuevo libro en la base de datos
    public void insertarEnBaseDeDatos(Connection connection) throws SQLException {
        String sql = "INSERT INTO libro (id, titulo, autor, isbn, disponible, copias_totales, libro_virtual, libro_fisico, editorial, categoria) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setObject(1, id);
            preparedStatement.setString(2, titulo);
            preparedStatement.setString(3, autor);
            preparedStatement.setString(4, isbn);
            preparedStatement.setString(5, disponible);
            preparedStatement.setInt(6, copiasTotales);
            preparedStatement.setObject(7, libroVirtual.getId());
            preparedStatement.setObject(8, libroFisico.getId());
            preparedStatement.setObject(9, editorial.getId());
            preparedStatement.setObject(10, categoria.getId());
            preparedStatement.executeUpdate();
        }
    }

    // Consultar un libro por ID
    public static Libro consultarPorId(Connection connection, UUID libroId) throws SQLException {
        String sql = "SELECT * FROM libro WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setObject(1, libroId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Construir y devolver un objeto Libro con los datos de la consulta
                    return new Libro(
                            (UUID) resultSet.getObject("id"),
                            resultSet.getString("titulo"),
                            resultSet.getString("autor"),
                            resultSet.getString("isbn"),
                            resultSet.getString("disponible"),
                            resultSet.getInt("copias_totales"),
                            new LibroVirtual((UUID) resultSet.getObject("libro_virtual")), // Crear objetos relacionados
                            new LibroFisico((UUID) resultSet.getObject("libro_fisico")),
                            new Editorial((UUID) resultSet.getObject("editorial")),
                            new Categoria((UUID) resultSet.getObject("categoria"))
                    );
                }
            }
        }
        return null; // Devolver null si no se encuentra el libro
    }

    // Actualizar los datos de un libro en la base de datos
    public void actualizarEnBaseDeDatos(Connection connection) throws SQLException {
        String sql = "UPDATE libro SET titulo = ?, autor = ?, isbn = ?, disponible = ?, copias_totales = ?, libro_virtual = ?, libro_fisico = ?, editorial = ?, categoria = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, autor);
            preparedStatement.setString(3, isbn);
            preparedStatement.setString(4, disponible);
            preparedStatement.setInt(5, copiasTotales);
            preparedStatement.setObject(6, libroVirtual.getId());
            preparedStatement.setObject(7, libroFisico.getId());
            preparedStatement.setObject(8, editorial.getId());
            preparedStatement.setObject(9, categoria.getId());
            preparedStatement.setObject(10, id);
            preparedStatement.executeUpdate();
        }
    }

    // Eliminar un libro de la base de datos
    public void eliminarDeBaseDeDatos(Connection connection) throws SQLException {
        String sql = "DELETE FROM libro WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();
        }
    }
}

