package com.bilioteca.biblioteca;


import com.biblioteca.usuario.Usuario;
import com.biblioteca.persona.Persona;
import com.biblioteca.persona.PersonaDAO;
import com.biblioteca.CRUD.GenericDAO;

import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import conexioDataBase.ConexionBD;

public class Biblioteca {

    public static void main(String[] args) {
        ConexionBD conexionBD = ConexionBD.obtenerInstancia();
        Connection conexion = conexionBD.conectar();

        if (conexion != null) {
            try {
                PersonaDAO personaDAO = new PersonaDAO(conexion);
                GenericDAO<Usuario> usuarioDAO = new GenericDAO<>(conexion);

                // Insertar un nuevo usuario
                Usuario nuevoUsuario = new Usuario();
                nuevoUsuario.setNombreUsuario("usuario1234");
                nuevoUsuario.setPassword("contraseña123");
                nuevoUsuario.setPersona("555555555");
                usuarioDAO.insertar(nuevoUsuario);

                // Obtener todos los usuarios
                List<Usuario> usuarios = usuarioDAO.obtenerTodos(Usuario.class);
                for (Usuario usuario : usuarios) {
                    System.out.println("Usuario: " + usuario.getNombreUsuario());
                }
                
               
                // Insertar una nueva persona
                Persona nuevaPersona = new Persona("1237894568787", "Juan Perez", "Calle 123");
                personaDAO.insertar(nuevaPersona);

                // Obtener todas las personas
                List<Persona> personas = personaDAO.obtenerTodos(Persona.class);
                for (Persona persona : personas) {
                    System.out.println(persona);
                }

            } catch (SQLException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            } finally {
                // Cierra la conexión cuando hayas terminado
                conexionBD.desconectar();
            }
        } else {
            System.err.println("No se pudo conectar a la base de datos.");
        }
    }
}
