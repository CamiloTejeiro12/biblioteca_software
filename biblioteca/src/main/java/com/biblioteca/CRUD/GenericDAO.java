/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.CRUD;

/**
 *
 * @author tejei
 */
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.lang.annotation.*;

public class GenericDAO<T> {
    private Connection connection;

    public GenericDAO(Connection connection) {
        this.connection = connection;
    }
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Id {
    }
    
    public void insertar(T entidad) throws SQLException, IllegalAccessException {
        Class<?> clase = entidad.getClass();
        Field[] campos = clase.getDeclaredFields();

        System.out.println("Class name: " + clase.getSimpleName());
        System.out.println("Number of fields: " + campos.length);

        // Check if the array of fields is empty
        if (campos.length == 0) {
            throw new IllegalArgumentException("No fields found in the entity class.");
        }

        StringBuilder columnas = new StringBuilder();
        StringBuilder valores = new StringBuilder();

        for (Field campo : campos) {
            campo.setAccessible(true);
            columnas.append(campo.getName()).append(",");
            valores.append("'").append(campo.get(entidad)).append("',");
        }

        // Remove the trailing comma from columnas and valores
        columnas.deleteCharAt(columnas.length() - 1);
        valores.deleteCharAt(valores.length() - 1);

        System.out.println("\nColumnas: " + columnas.toString());
        System.out.println("Valores: " + valores.toString() + "\n");

        String sql = "INSERT INTO " + clase.getSimpleName() + " (" + columnas + ") VALUES (" + valores + ")";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }


    public List<T> obtenerTodos(Class<T> clase) throws SQLException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM " + clase.getSimpleName();
        List<T> entidades = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                T entidad = clase.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Field field = null;
                    try {
                        field = clase.getDeclaredField(columnName);
                    } catch (NoSuchFieldException e) {
                        // Ignorar columnas que no tienen correspondencia en la clase
                        continue;
                    }
                    field.setAccessible(true);
                    field.set(entidad, resultSet.getObject(columnName));
                }
                entidades.add(entidad);
            }
        }
        return entidades;
    }
    
    public T obtenerPorId(Class<T> clase, Object id) throws SQLException, InstantiationException, IllegalAccessException {
        String primaryKeyColumn = "id"; // Nombre de tu columna de clave primaria (puedes cambiar esto según tu base de datos)
        String sql = "SELECT * FROM " + clase.getSimpleName() + " WHERE " + primaryKeyColumn + " = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setObject(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                T entidad = clase.newInstance();
                for (Field field : clase.getDeclaredFields()) {
                    field.setAccessible(true);
                    field.set(entidad, resultSet.getObject(field.getName()));
                }
                return entidad;
            } else {
                return null; // No se encontró el objeto con la clave primaria proporcionada
            }
        }
    }

    
    public void actualizar(T entidad) throws SQLException, IllegalAccessException {
        Class<?> clase = entidad.getClass();
        Field[] campos = clase.getDeclaredFields();
        StringBuilder setClause = new StringBuilder();
        String primaryKeyColumnName = null;
        Object primaryKeyValue = null;

        for (Field campo : campos) {
            campo.setAccessible(true);
            if (campo.isAnnotationPresent(Id.class)) {
                // Si es una clave primaria, almacenar su nombre y valor
                primaryKeyColumnName = campo.getName();
                primaryKeyValue = campo.get(entidad);
            } else {
                // Si no es una clave primaria, agregar al conjunto de la cláusula SET
                setClause.append(campo.getName()).append(" = ?, ");
            }
        }

        // Eliminar la coma adicional al final del conjunto de la cláusula SET
        setClause.deleteCharAt(setClause.length() - 2);

        // Construir la consulta SQL
        String sql = "UPDATE " + clase.getSimpleName() + " SET " + setClause.toString() +
                " WHERE " + primaryKeyColumnName + " = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int index = 1;
            for (Field campo : campos) {
                campo.setAccessible(true);
                if (!campo.isAnnotationPresent(Id.class)) {
                    // Establecer los valores de los campos no clave
                    statement.setObject(index++, campo.get(entidad));
                }
            }
            // Establecer el valor de la clave primaria en la cláusula WHERE
            statement.setObject(index, primaryKeyValue);
            statement.executeUpdate();
        }
        
    }
        
        
    public void eliminar(T entidad) throws SQLException, IllegalAccessException {
        Class<?> clase = entidad.getClass();
        Field primaryKeyField = null;
        
        // Encuentra el campo que tiene la anotación @Id (o el primer campo si no hay anotación @Id)
        for (Field campo : clase.getDeclaredFields()) {
            if (campo.isAnnotationPresent(Id.class) || primaryKeyField == null) {
                primaryKeyField = campo;
            }
        }
        
        if (primaryKeyField != null) {
            primaryKeyField.setAccessible(true);
            Object primaryKeyValue = primaryKeyField.get(entidad);

            // Construir la consulta SQL
            String sql = "DELETE FROM " + clase.getSimpleName() + " WHERE " + primaryKeyField.getName() + " = ?";
            
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Establecer el valor de la clave primaria en la cláusula WHERE
                statement.setObject(1, primaryKeyValue);
                statement.executeUpdate();
            }
        } else {
            throw new IllegalArgumentException("La entidad no tiene una clave primaria válida.");
        }
    }
    
    
}
