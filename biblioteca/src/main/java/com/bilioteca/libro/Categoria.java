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

public class Categoria implements InterfaceCategoria {
    private UUID id;
    private String descripcion;

    public Categoria(UUID id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /*
    // Métodos específicos para Categoria
    public void agregarLibro(InterfaceLibroFisico libroFisico) {
        // Implementación para agregar un libro a la categoría
        System.out.println("Agregando libro con ID: " + libroFisico.getId() +
                           ", Título: " + libroFisico.getTitulo() +
                           " a la categoría " + descripcion);
    }
*/
}
