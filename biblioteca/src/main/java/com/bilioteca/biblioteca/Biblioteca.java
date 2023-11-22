package com.bilioteca.biblioteca;

import com.biblioteca.usuario.Usuario;
import com.biblioteca.persona.Persona;
import com.biblioteca.persona.PersonaDAO;
import com.biblioteca.CRUD.GenericDAO;
import com.biblioteca.libro.LibroFisicoDAO;

import com.biblioteca.libro.Editorial;
import com.biblioteca.libro.Libro;
import com.biblioteca.libro.LibroFisico;
import com.biblioteca.libro.LibroVirtual;

import com.biblioteca.multa.Multa;

import com.biblioteca.prestamo.Prestamo;

import com.biblioteca.categoria.Categoria;


import com.biblioteca.libro.LibroFisicoDAO;


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
                GenericDAO<Libro> libroDAO = new GenericDAO<>(conexion);
                GenericDAO<LibroVirtual> libroVirtualDAO = new GenericDAO<>(conexion);
                GenericDAO<Editorial> EditorialDAO = new GenericDAO<>(conexion);
                GenericDAO<Categoria> CategoriaDAO = new GenericDAO<>(conexion);
                
                
                LibroFisicoDAO LibroFisicoDAO = new LibroFisicoDAO(conexion);

                /*
                LibroFisicoDAO libroFisicoDAO = new LibroFisicoDAO();
                
                // Insertar un nuevo libro físico
                LibroFisico nuevoLibroFisico = new LibroFisico("ID_LIBRO_FISICO", "Estantería A", "Disponible");
                libroFisicoDAO.insertarLibroFisico(nuevoLibroFisico);
                
                                // Obtener todos los libros físicos
                List<LibroFisico> librosFisicos = libroFisicoDAO.obtenerTodosLosLibrosFisicos();
                for (LibroFisico libroFisico : librosFisicos) {
                    System.out.println("Libro Físico: " + libroFisico.getId() + ", Ubicación: " + libroFisico.getUbicacion());
                }

                */
                
                
                
                // Insertar una nueva persona
                Persona nuevaPersona = new Persona("555555596", "Juan Perez", "Calle 123");
                personaDAO.insertar(nuevaPersona);

                // Obtener todas las personas
                List<Persona> personas = personaDAO.obtenerTodos(Persona.class);
                for (Persona persona : personas) {
                    System.out.println(persona);
                }

                System.out.println("\n==============================================\n");

                
                // Insertar un nuevo usuario
                Usuario nuevoUsuario = new Usuario();
                nuevoUsuario.setNombreUsuario("usuario12348");
                nuevoUsuario.setPassword("contraseña123");
                nuevoUsuario.setPersona("555555555");
                usuarioDAO.insertar(nuevoUsuario);
                
                
                System.out.println("Listado de usuarios");
                // Obtener todos los usuarios
                List<Usuario> usuarios = usuarioDAO.obtenerTodos(Usuario.class);
                for (Usuario usuario : usuarios) {
                    System.out.println("Usuario: " + usuario.getNombreUsuario());
                }

                System.out.println("\n==============================================\n");


                // Utilizar una consulta SQL estándar para obtener la fecha y hora actual
                String consulta = "SELECT CURRENT_TIMESTAMP as fecha_actual";

                // Crear una sentencia preparada
                PreparedStatement stmt = conexion.prepareStatement(consulta);

                // Ejecutar la consulta
                ResultSet resultado = stmt.executeQuery();

                // Leer el resultado
                if (resultado.next()) {
                    String fechaActual = resultado.getString("fecha_actual");
                    System.out.println("Fecha y hora actual de la base de datos: " + fechaActual);
                }
                
                System.out.println("\n==============================================\n");
                
                
                /*

                // Obtener usuario por ID
                Usuario usuarioExistente = usuarioDAO.obtenerPorId(Usuario.class, nuevoUsuario.getId());
                if (usuarioExistente != null) {
                    usuarioExistente.setNombreUsuario("user4");
                    usuarioExistente.setPassword("pass4");
                    usuarioDAO.actualizar(usuarioExistente);
                } else {
                    System.out.println("Usuario no encontrado");
                }

                // Eliminar una persona existente
                Persona personaAEliminar = personaDAO.obtenerPorId(Persona.class, "555555557");
                if (personaAEliminar != null) {
                    personaDAO.eliminar(personaAEliminar);
                } else {
                    System.out.println("Persona no encontrada");
                }
                */
                
                
                //Libro
                
                

                // Insertar un nuevo libro
                Libro nuevoLibro = new Libro();

                
                nuevoLibro.setTitulo("El sennor de los anillos");
                nuevoLibro.setReview("Gran libro de fantasia");
                nuevoLibro.setDisponible("Si");
                nuevoLibro.setCopiasTotales(10);
                nuevoLibro.setIsbn("78-84-450-73701");
                nuevoLibro.setAutor("J.R.R. Tolkien");
                nuevoLibro.setLibroVirtual("1"); // Reemplaza con el ID correcto
                nuevoLibro.setLibroFisico("1"); // Reemplaza con el ID correcto
                nuevoLibro.setEditorial("1"); // Reemplaza con el ID correcto
                nuevoLibro.setCategoria("1"); // Reemplaza con el ID correcto

                
                
                
                libroDAO.insertar(nuevoLibro);

                // Obtener todos los libros
                System.out.println("Listado de libros");
                List<Libro> libros = libroDAO.obtenerTodos(Libro.class);
                for (Libro libro : libros) {
                    System.out.println("Libro: " + libro.getTitulo());
                }
                System.out.println("\n==============================================\n");


                // Obtener libro por ID
                Libro libroExistente = libroDAO.obtenerPorId(Libro.class, nuevoLibro.getId());
                if (libroExistente != null) {
                    libroExistente.setTitulo("El Hobbit");
                    libroDAO.actualizar(libroExistente);
                } else {
                    System.out.println("Libro no encontrado");
                }

                // Eliminar un libro existente
                
                String idLibroAEliminar  = "398fd81a-3ba1-4fca-9432-95cc143bb958";
                Libro libroAEliminar = libroDAO.obtenerPorId(Libro.class, idLibroAEliminar ); // Reemplaza con el ID correcto
                if (libroAEliminar != null) {
                    System.out.println("Libro a eliminar:");
                    System.out.println("ID: " + libroAEliminar.getId());
                    System.out.println("Título: " + libroAEliminar.getTitulo());
                    System.out.println("Autor: " + libroAEliminar.getAutor());
                    
                    libroDAO.eliminar(libroAEliminar);
                    System.out.println("Libro eliminado con éxito.");

                    // Listar los libros después de la eliminación
                    System.out.println("Listado de libros después de la eliminación");
                    List<Libro> librosDespuesDeEliminar = libroDAO.obtenerTodos(Libro.class);
                    for (Libro libro : librosDespuesDeEliminar) {
                        System.out.println("Libro: " + libro.getTitulo());
                    }
                } else {
                    System.out.println("Libro no encontrado");
                }
                
                
                
                
                
                
 /*               
                // Crear un nuevo libro con el método de fábrica
                LibroConcreto nuevoLibro = LibroConcreto.crearNuevoLibro(
                        "Harry Potter",
                        "Increíble historia de magia",
                        "Sí",
                        20,
                        "978-0-7475-3269-6",
                        "J.K. Rowling",
                        "ID_DEL_LIBRO_VIRTUAL",
                        "ID_DEL_LIBRO_FISICO",
                        "ID_DE_LA_EDITORIAL",
                        "ID_DE_LA_CATEGORIA"
                );

                
                // Insertar el nuevo libro en la base de datos
                libroDAO.insertar(nuevoLibro);

                // Obtener todos los libros
                System.out.println("Listado de libros");
                List<LibroConcreto> libros = libroDAO.obtenerTodos(LibroConcreto.class);
                for (Libro libro : libros) {
                    System.out.println("Libro: " + libro.getTitulo());
                }

                // Obtener libro por ID
                LibroConcreto libroExistente = libroDAO.obtenerPorId(LibroConcreto.class, nuevoLibro.getId());
                if (libroExistente != null) {
                    libroExistente.setTitulo("Harry Potter y la Cámara Secreta");
                    libroDAO.actualizar(libroExistente);
                } else {
                    System.out.println("Libro no encontrado");
                }

                // Eliminar un libro existente
                LibroConcreto libroAEliminar = libroDAO.obtenerPorId(LibroConcreto.class, "ID_DEL_LIBRO_A_ELIMINAR");
                if (libroAEliminar != null) {
                    libroDAO.eliminar(libroAEliminar);
                } else {
                    System.out.println("Libro no encontrado");
                }
*/
                

            } catch (SQLException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            } finally {
                // Cerrar la conexión cuando hayas terminado
                conexionBD.desconectar();
            }
        } else {
            System.err.println("No se pudo conectar a la base de datos.");
        }
    }
}
