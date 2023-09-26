/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilioteca.biblioteca;

/**
 *
 * @author tejei
 */
import java.util.ArrayList;
import java.util.List;

public class LibroFisico {

    // Lista para almacenar objetos LibroFisico
    private static List<LibroFisico> librosFisicos = new ArrayList<>();

    // Atributos de la clase
    private int id;
    private String ubicacion;
    private String estado;

    // Constructor
    public LibroFisico(int id, String ubicacion, String estado) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    // Método para insertar un libro físico en la lista
    public void insertarLibroFisico(LibroFisico libroFisico) {
        librosFisicos.add(libroFisico);
    }

    // Método para consultar un libro físico por su ID
    public LibroFisico consultarLibroFisicoPorId(int id) {
        for (LibroFisico libroFisico : librosFisicos) {
            if (libroFisico.id == id) {
                return libroFisico;
            }
        }
        return null; // Si no se encuentra el libro físico
    }

    // Método para actualizar los datos de un libro físico
    public void actualizarLibroFisico(LibroFisico libroFisico) {
        int index = librosFisicos.indexOf(libroFisico);
        if (index != -1) {
            librosFisicos.set(index, libroFisico);
        } else {
            System.out.println("El libro físico no existe en la lista.");
        }
    }

    // Método para eliminar un libro físico de la lista
    public void eliminarLibroFisico(LibroFisico libroFisico) {
        librosFisicos.remove(libroFisico);
    }

        // Lista para almacenar objetos LibroFisico    
    // Otros métodos getters y setters, si es necesario
}
