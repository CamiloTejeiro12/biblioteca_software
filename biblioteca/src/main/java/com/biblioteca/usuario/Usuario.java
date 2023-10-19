/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.usuario;

/**
 *
 * @author tejei
 */
import java.util.UUID;

public class Usuario implements UsuarioInterface {
    private UUID id;
    private String nombre_usuario;
    private String password;
    private String persona;  // Nueva propiedad

    public Usuario() {
        this.id = UUID.randomUUID();
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
    public UUID getId() {
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
