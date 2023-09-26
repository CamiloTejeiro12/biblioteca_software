package com.bilioteca.biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import com.bilioteca.biblioteca.Usuario;

public class Biblioteca {

    public static void main(String[] args) {
        // Crear un nuevo usuario
        Usuario nuevoUsuario = new Usuario("1234567890", "John Doe", "123 Main St", "johndoe", "secreto");
        nuevoUsuario.crearUsuario();

        // Listar todos los usuarios
        List<Usuario> usuarios = Usuario.listarUsuarios();
        for (Usuario usuario : usuarios) {
            System.out.println("Cedula: " + usuario.getCedula());
            System.out.println("Nombre de Usuario: " + usuario.getNombreUsuario());
            System.out.println("Contraseña: " + usuario.getPassword());
            System.out.println();
        }

        // Actualizar un usuario (asumiendo que existe en la base de datos)
        Usuario usuarioExistente = usuarios.get(0); // Obtener el primer usuario de la lista
        usuarioExistente.setNombreUsuario("nuevoUsuario");
        usuarioExistente.setPassword("nuevaContraseña");
        usuarioExistente.actualizarUsuario();

        // Eliminar un usuario (asumiendo que existe en la base de datos)
        Usuario usuarioAEliminar = usuarios.get(1); // Obtener el segundo usuario de la lista
        usuarioAEliminar.eliminarUsuario();

        // Volver a listar usuarios después de eliminar uno
        usuarios = Usuario.listarUsuarios();
        for (Usuario usuario : usuarios) {
            System.out.println("Cedula: " + usuario.getCedula());
            System.out.println("Nombre de Usuario: " + usuario.getNombreUsuario());
            System.out.println("Contraseña: " + usuario.getPassword());
            System.out.println();
        }

        
    }
}
