package com.biblioteca.usuario;

/**
 *
 * @author tejei
 */
public interface UsuarioInterface {
    String getId(); // Cambiado de UUID a String
    String getNombreUsuario();
    void setNombreUsuario(String nombre_usuario);
    String getPassword();
    void setPassword(String password);
    String getPersona();
    void setPersona(String persona);
}
