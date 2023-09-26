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

public class Categoria {

    // Lista para almacenar objetos Categoria
    private static List<Categoria> categorias = new ArrayList<>();

    // Atributos de la clase
    private int id;
    private String descripcion;

    // Constructor
    public Categoria(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    // Método para insertar una categoría en la lista
    public void insertarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    // Método para consultar una categoría por su ID
    public Categoria consultarCategoriaPorId(int id) {
        for (Categoria categoria : categorias) {
            if (categoria.id == id) {
                return categoria;
            }
        }
        return null; // Si no se encuentra la categoría
    }

    // Método para actualizar los datos de una categoría
    public void actualizarCategoria(Categoria categoria) {
        int index = categorias.indexOf(categoria);
        if (index != -1) {
            categorias.set(index, categoria);
        } else {
            System.out.println("La categoría no existe en la lista.");
        }
    }

    // Método para eliminar una categoría de la lista
    public void eliminarCategoria(Categoria categoria) {
        categorias.remove(categoria);
    }

    // Otros métodos getters y setters, si es necesario
}
