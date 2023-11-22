/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biblioteca.membresia;

/**
 *
 * @author tejei
 */

import com.biblioteca.usuario.Usuario;


import java.util.List;

public interface MembresiaInterface {
    public String getId();
    public void setId(String id);
    public String getTipo();
    public void setTipo(String tipo);
    public String getBeneficios();
    public void setBeneficios(String beneficios);
    public Usuario getUsuario();
    public void setUsuario(Usuario usuario);
    public String toString();
}

