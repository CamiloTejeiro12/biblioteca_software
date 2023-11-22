/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.membresia;

/**
 *
 * @author tejei
 */

import com.biblioteca.usuario.Usuario;

public class Membresia implements MembresiaInterface {
    private String id;
    private String tipo;
    private String beneficios;
    private Usuario usuario;

    // Constructores, getters y setters

    public Membresia() {
        // Constructor vacío
    }

    public Membresia(String id, String tipo, String beneficios, Usuario usuario) {
        this.id = id;
        this.tipo = tipo;
        this.beneficios = beneficios;
        this.usuario = usuario;
    }

    // Getters y setters para cada atributo

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getBeneficios() {
        return beneficios;
    }

    @Override
    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    @Override
    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Membresia [id=" + id + ", tipo=" + tipo + ", beneficios=" + beneficios + ", usuario=" + usuario + "]";
    }
}

