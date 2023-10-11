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

public class Editorial implements InterfaceEditorial {
    private UUID id;
    private String nombre;

    public Editorial(UUID id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos específicos para Editorial
    public void publicarLibro(InterfaceLibroFisico libroFisico) {
        // Implementación para publicar un libro físico
        System.out.println("Publicando libro físico con ID: " + libroFisico.getId() +
                           " de la editorial " + nombre);
    }
}
