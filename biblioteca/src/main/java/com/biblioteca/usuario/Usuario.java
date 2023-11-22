package com.biblioteca.usuario;

import com.biblioteca.CRUD.GenericDAO;

/**
 *
 * @author tejei
 */
public class Usuario implements UsuarioInterface {
    @GenericDAO.Id
    private String id;
    private String nombre_usuario;
    private String password;
    private String persona;

    public Usuario() {
        // Utilizando generador UUID y almacenando como String
        this.id = java.util.UUID.randomUUID().toString();
    }

    @Override
    public String getPersona() {
        return persona;
    }

    @Override
    public void setPersona(String persona) {
        this.persona = persona;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNombreUsuario() {
        return nombre_usuario;
    }

    @Override
    public void setNombreUsuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
