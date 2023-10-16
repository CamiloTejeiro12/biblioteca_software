package com.bilioteca.biblioteca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PostgreSQLUsuarioRepository implements UsuarioRepository {
    private Connection connection;

    public PostgreSQLUsuarioRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearPersona(Persona persona) {
        try {
            String sql = "INSERT INTO persona (cedula, nombre, direccion) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, persona.getCedula());
            preparedStatement.setString(2, persona.getNombre());
            preparedStatement.setString(3, persona.getDireccion());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Persona buscarPersonaPorCedula(String cedula) {
        Persona persona = null;
        try {
            String sql = "SELECT * FROM persona WHERE cedula = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cedula);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                persona = new Persona();
                persona.setCedula(resultSet.getString("cedula"));
                persona.setNombre(resultSet.getString("nombre"));
                persona.setDireccion(resultSet.getString("direccion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persona;
    }

    @Override
    public void actualizarPersona(Persona persona) {
        try {
            String sql = "UPDATE persona SET nombre = ?, direccion = ? WHERE cedula = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getDireccion());
            preparedStatement.setString(3, persona.getCedula());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarPersona(String cedula) {
        try {
            String sql = "DELETE FROM persona WHERE cedula = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cedula);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        try {
            String sql = "INSERT INTO usuario (persona, nombre_usuario, contraseña) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getCedula());
            preparedStatement.setString(2, usuario.getNombreUsuario());
            preparedStatement.setString(3, usuario.getContraseña());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario buscarUsuarioPorCedula(String cedula) {
        Usuario usuario = null;
        try {
            String sql = "SELECT * FROM usuario WHERE persona = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cedula);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usuario = new Usuario();
                usuario.setCedula(resultSet.getString("cedula"));
                usuario.setNombreUsuario(resultSet.getString("nombre_usuario"));
                usuario.setContraseña(resultSet.getString("contraseña"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        try {
            String sql = "UPDATE usuario SET nombre_usuario = ?, contraseña = ? WHERE cedula = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getNombreUsuario());
            preparedStatement.setString(2, usuario.getContraseña());
            preparedStatement.setString(3, usuario.getCedula());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarUsuario(String cedula) {
        try {
            String sql = "DELETE FROM usuario WHERE cedula = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cedula);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
