package com.bilioteca.biblioteca;

public interface UsuarioRepository extends PersonaRepository {
    void crearUsuario(Usuario usuario);
    Usuario buscarUsuarioPorCedula(String cedula);
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(String cedula);
}
