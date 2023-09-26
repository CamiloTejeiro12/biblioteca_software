/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilioteca.biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Persona {
    private String cedula;
    private String nombre;
    private String direccion;

    public Persona(String cedula, String nombre, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Métodos para operaciones CRUD en Persona

    public String crearPersona() {
        Connection conexion = ConexionBDUtil.obtenerConexion();
        String sql = "INSERT INTO persona (cedula, nombre, direccion) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, cedula);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, direccion);

            preparedStatement.executeUpdate();

            // Devolvemos la cedula como resultado de la creación
            return cedula;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionBDUtil.cerrarConexion();
        }

        return null; // En caso de error
    }

    public void actualizarPersona() {
        Connection conexion = ConexionBDUtil.obtenerConexion();
        String sql = "UPDATE persona SET nombre = ?, direccion = ? WHERE cedula = ?";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, direccion);
            preparedStatement.setString(3, cedula);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionBDUtil.cerrarConexion();
        }
    }

    public void eliminarPersona() {
        Connection conexion = ConexionBDUtil.obtenerConexion();
        String sql = "DELETE FROM persona WHERE cedula = ?";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, cedula);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionBDUtil.cerrarConexion();
        }
    }
}