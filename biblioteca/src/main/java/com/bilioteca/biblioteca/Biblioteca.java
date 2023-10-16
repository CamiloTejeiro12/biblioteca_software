package com.bilioteca.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

public class Biblioteca {

    public static void main(String[] args) {
        // Configurar la conexión a la base de datos PostgreSQL
        String jdbcUrl = "jdbc:postgresql://localhost:5432/biblioteca";
        String username = "jhon";
        String password = "123456";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // Crear repositorios
            PersonaRepository personaRepository = new PostgreSQLUsuarioRepository(connection);
            UsuarioRepository usuarioRepository = new PostgreSQLUsuarioRepository(connection);

            // Buscar una persona por cédula
            Persona personaEncontrada = personaRepository.buscarPersonaPorCedula("123456");
            System.out.println("Persona encontrada: " + personaEncontrada.getNombre());

            // Buscar un usuario por cédula
            Usuario usuarioEncontrado = usuarioRepository.buscarUsuarioPorCedula("555555555");
            System.out.println("Usuario encontrado: " + usuarioEncontrado.getNombreUsuario());
            
            // Crear un usuario
            Usuario nuevoUsuario = new Usuario("123456", "Juan Pérez", "Calle 123", "Juan Pérez", "Contraseña123");
            usuarioRepository.crearUsuario(nuevoUsuario);
            
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
