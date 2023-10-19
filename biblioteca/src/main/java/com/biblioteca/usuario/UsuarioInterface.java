/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biblioteca.usuario;

/**
 *
 * @author tejei
 */
import java.util.UUID;

public interface UsuarioInterface {
    UUID getId();
    String getNombreUsuario();
    void setNombreUsuario(String nombre_usuario);
    String getPassword();
    void setPassword(String password);
    String getPersona();
    void setPersona(String persona);
}
