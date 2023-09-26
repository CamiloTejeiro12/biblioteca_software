package com.bilioteca.biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Biblioteca {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Connection conexion = ConexionBDUtil.obtenerConexion();
        try {
            String consultaSQL = "SELECT usuario.id, usuario.nombre_usuario, usuario.\"contraseña\", persona.nombre, persona.direccion " +
                                 "FROM usuario " +
                                 "JOIN persona ON usuario.persona = persona.cedula";
            PreparedStatement statement = conexion.prepareStatement(consultaSQL);

            // Ejecutar la consulta y obtener el conjunto de resultados
            ResultSet resultSet = statement.executeQuery();

            // Procesar y mostrar los resultados
            while (resultSet.next()) {
                String idUsuario = resultSet.getString("id");
                String nombreUsuario = resultSet.getString("nombre_usuario");
                String contraseña = resultSet.getString("contraseña");
                String nombrePersona = resultSet.getString("nombre");
                String direccionPersona = resultSet.getString("direccion");

                System.out.println("ID de Usuario: " + idUsuario);
                System.out.println("Nombre de Usuario: " + nombreUsuario);
                System.out.println("Contraseña: " + contraseña);
                System.out.println("Nombre de Persona: " + nombrePersona);
                System.out.println("Dirección de Persona: " + direccionPersona);
                System.out.println("---------------------------");
            }

            // Cerrar el ResultSet, el PreparedStatement y la conexión cuando hayas terminado
            resultSet.close();
            statement.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
