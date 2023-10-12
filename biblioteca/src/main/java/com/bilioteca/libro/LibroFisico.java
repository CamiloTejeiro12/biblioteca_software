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

import java.util.UUID;


public class LibroFisico implements InterfaceLibroFisico, InterfaceLibro {
    private UUID id;
    private String ubicacion;
    private String estado;

    private InterfaceLibro libro;


    public LibroFisico(UUID id, String ubicacion, String estado) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

   
    // Métodos específicos para libros físicos
    public void organizando() {
        System.out.println("Ubicando un libro físico con ID: " + ubicacion);
    }

    @Override
    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getTitulo() {
        return this.libro.getTitulo();
    }

    @Override
    public String getReview() {
        return this.libro.getReview();
    }

    @Override
    public String getDisponible() {
        return this.libro.getDisponible();
    }

    @Override
    public int getCopiasTotales() {
        return this.libro.getCopiasTotales();
    }

    @Override
    public String getIsbn() {
        return this.libro.getIsbn();
    }

    @Override
    public String getAutor() {
        return this.libro.getAutor();
    }

    @Override
    public LibroVirtual getLibroVirtual() {
        return this.libro.getLibroVirtual();
    }

    @Override
    public LibroFisico getLibroFisico() {
        return this.libro.getLibroFisico();
    }

    @Override
    public Editorial getEditorial() {
        return this.libro.getEditorial();
    }

    @Override
    public Categoria getCategoria() {
        return this.libro.getCategoria();
    }

    @Override
    public String getEstado() {
        return estado;
    }
}
