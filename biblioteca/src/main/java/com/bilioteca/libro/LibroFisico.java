/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilioteca.libro;

/**
 *
 * @author tejei
 */
import java.util.UUID;

public class LibroFisico implements InterfaceLibroFisico {
    private UUID id;
    private String ubicacion;
    private String estado;

    public LibroFisico(UUID id, String ubicacion, String estado) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    @Override
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Métodos específicos para libros físicos
    public void reparar() {
        // Implementación para reparar un libro físico
        System.out.println("Reparando libro físico con ID: " + id);
    }
}
