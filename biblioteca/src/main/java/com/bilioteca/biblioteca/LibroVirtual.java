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

public class LibroVirtual {

    // Lista para almacenar objetos LibroVirtual
    private static List<LibroVirtual> librosVirtuales = new ArrayList<>();

    // Atributos de la clase
    private int id;
    private String titulo;
    private String formatoElectronico;
    private String resumen;
    private String tamanoArchivo;

    // Constructor
    public LibroVirtual(int id, String titulo, String formatoElectronico, String resumen, String tamanoArchivo) {
        this.id = id;
        this.titulo = titulo;
        this.formatoElectronico = formatoElectronico;
        this.resumen = resumen;
        this.tamanoArchivo = tamanoArchivo;
    }

        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFormatoElectronico() {
        return formatoElectronico;
    }

    public void setFormatoElectronico(String formatoElectronico) {
        this.formatoElectronico = formatoElectronico;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getTamanoArchivo() {
        return tamanoArchivo;
    }

    public void setTamanoArchivo(String tamanoArchivo) {
        this.tamanoArchivo = tamanoArchivo;
    }
    
    // Método para insertar un libro virtual en la lista
    public void insertarLibroVirtual(LibroVirtual libroVirtual) {
        librosVirtuales.add(libroVirtual);
    }

    // Método para consultar un libro virtual por su ID
    public LibroVirtual consultarLibroVirtualPorId(int id) {
        for (LibroVirtual libroVirtual : librosVirtuales) {
            if (libroVirtual.id == id) {
                return libroVirtual;
            }
        }
        return null; // Si no se encuentra el libro virtual
    }

    // Método para actualizar los datos de un libro virtual
    public void actualizarLibroVirtual(LibroVirtual libroVirtual) {
        int index = librosVirtuales.indexOf(libroVirtual);
        if (index != -1) {
            librosVirtuales.set(index, libroVirtual);
        } else {
            System.out.println("El libro virtual no existe en la lista.");
        }
    }

    // Método para eliminar un libro virtual de la lista
    public void eliminarLibroVirtual(LibroVirtual libroVirtual) {
        librosVirtuales.remove(libroVirtual);
    }

    // Otros métodos getters y setters, si es necesario
}
