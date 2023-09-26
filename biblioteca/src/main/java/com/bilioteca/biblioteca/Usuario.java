
package com.bilioteca.biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class Usuario extends Persona {
    private String nombreUsuario;
    private String contraseña;

    public Usuario(String cedula, String nombre, String direccion, String nombreUsuario, String contraseña) {
        super(cedula, nombre, direccion);
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return contraseña;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setPassword(String contraseña) {
        this.contraseña = contraseña;
    }


    // Método para crear un nuevo usuario y asignarle la persona correspondiente
    public void crearUsuario() {
        // Primero, creamos la persona y obtenemos su cedula
        
        String cedulaPersona = crearPersona();
        System.out.println(cedulaPersona);
        // Luego, llenamos los campos de la persona en la instancia de Usuario
        setCedula(cedulaPersona);
        
        // Finalmente, creamos el usuario con la cedula de la persona
        Connection conexion = ConexionBDUtil.obtenerConexion();
        String sql = "INSERT INTO usuario (persona, nombre_usuario, \"contraseña\") VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, cedulaPersona);
            preparedStatement.setString(2, nombreUsuario);
            preparedStatement.setString(3, contraseña);
            System.out.println("aqyi");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionBDUtil.cerrarConexion();
        }
    }
    
    public void actualizarUsuario() {
        Connection conexion = ConexionBDUtil.obtenerConexion();
        String sql = "UPDATE usuario SET nombre_usuario = ?, \"contraseña\" = ? WHERE persona = ?";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, nombreUsuario);
            preparedStatement.setString(2, contraseña);
            preparedStatement.setString(3, getCedula()); // Utilizamos getCedula() de la superclase Persona
            preparedStatement.executeUpdate();
            System.out.println("Usuario actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionBDUtil.cerrarConexion();
        }
    }
    
    public static List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Connection conexion = ConexionBDUtil.obtenerConexion();
        String sql = "SELECT * FROM usuario";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String cedula = resultSet.getString("persona");
                String nombreUsuario = resultSet.getString("nombre_usuario");
                String contraseña = resultSet.getString("contraseña");
                Usuario usuario = new Usuario(cedula, null, null, nombreUsuario, contraseña);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionBDUtil.cerrarConexion();
        }
        return usuarios;
    }
    
    public void eliminarUsuario() {
        Connection conexion = ConexionBDUtil.obtenerConexion();
        String sql = "DELETE FROM usuario WHERE persona = ?";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, getCedula()); // Utilizamos getCedula() de la superclase Persona
            preparedStatement.executeUpdate();
            System.out.println("Usuario eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionBDUtil.cerrarConexion();
        }
    }



}