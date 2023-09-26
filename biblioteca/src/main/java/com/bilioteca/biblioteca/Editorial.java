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

public class Editorial {

    // Lista para almacenar objetos Editorial
    private static List<Editorial> editoriales = new ArrayList<>();

    // Atributos de la clase
    private int id;
    private String nombre;

    // Constructor
    public Editorial(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para insertar una editorial en la lista
    public void insertarEditorial(Editorial editorial) {
        editoriales.add(editorial);
    }

    // Método para consultar una editorial por su ID
    public Editorial consultarEditorialPorId(int id) {
        for (Editorial editorial : editoriales) {
            if (editorial.id == id) {
                return editorial;
            }
        }
        return null; // Si no se encuentra la editorial
    }

    // Método para actualizar los datos de una editorial
    public void actualizarEditorial(Editorial editorial) {
        int index = editoriales.indexOf(editorial);
        if (index != -1) {
            editoriales.set(index, editorial);
        } else {
            System.out.println("La editorial no existe en la lista.");
        }
    }

    // Método para eliminar una editorial de la lista
    public void eliminarEditorial(Editorial editorial) {
        editoriales.remove(editorial);
    }

    // Otros métodos getters y setters, si es necesario
}
