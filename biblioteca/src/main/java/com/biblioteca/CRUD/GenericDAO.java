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

public class GenericDAO<T> {
    private Connection connection;

    public GenericDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertar(T entidad) throws SQLException, IllegalAccessException {
        Class<?> clase = entidad.getClass();
        Field[] campos = clase.getDeclaredFields();
        StringBuilder columnas = new StringBuilder();
        StringBuilder valores = new StringBuilder();

        for (Field campo : campos) {
            campo.setAccessible(true);
            columnas.append(campo.getName()).append(",");
            valores.append("'").append(campo.get(entidad)).append("',");
        }

        columnas.deleteCharAt(columnas.length() - 1);
        valores.deleteCharAt(valores.length() - 1);

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
}
