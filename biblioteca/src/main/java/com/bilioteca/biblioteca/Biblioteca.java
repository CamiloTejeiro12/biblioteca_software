package com.bilioteca.biblioteca;


import com.biblioteca.usuario.Usuario;
import com.biblioteca.persona.Persona;
import com.biblioteca.persona.PersonaDAO;
import com.biblioteca.CRUD.GenericDAO;

import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import conexioDataBase.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


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
                
                
                // Utiliza una consulta SQL estándar para obtener la fecha y hora actual
                String consulta = "SELECT CURRENT_TIMESTAMP as fecha_actual";

                // Crea una sentencia preparada
                PreparedStatement stmt = conexion.prepareStatement(consulta);

                // Ejecuta la consulta
                ResultSet resultado = stmt.executeQuery();

                // Lee el resultado
                if (resultado.next()) {
                    String fechaActual = resultado.getString("fecha_actual");
                    System.out.println("Fecha y hora actual de la base de datos: " + fechaActual);
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
