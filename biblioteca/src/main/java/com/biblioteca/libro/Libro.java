/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.libro;

import com.biblioteca.categoria.Categoria;

import java.util.UUID;


/**
 *
 * @author tejei
 */

import com.biblioteca.libro.LibroFisico;
import com.biblioteca.libro.LibroVirtual;
import com.biblioteca.libro.Editorial;
import com.biblioteca.categoria.Categoria;


public class Libro implements LibroInterface{

    private String id;
    private String titulo;
    private String review;
    private String disponible;
    private int copias_totales;
    private String isbn;
    private String autor;
    private String libro_virtual;
    private String libro_fisico;
    private String editorial;
    private String categoria;

    public Libro() {
    this.id = java.util.UUID.randomUUID().toString();
    }

    
    /*
    // Constructor protegido
    protected Libro(String id, String titulo, String review, String disponible, int copiasTotales,
                String isbn, String autor, String libroVirtual, String libroFisico,
                String editorial, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.review = review;
        this.disponible = disponible;
        this.copiasTotales = copiasTotales;
        this.isbn = isbn;
        this.autor = autor;
        this.libroVirtual = libroVirtual;
        this.libroFisico = libroFisico;
        this.editorial = editorial;
        this.categoria = categoria;
    }
    
    
    */
    
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String getReview() {
        return review;
    }

    @Override
    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String getDisponible() {
        return disponible;
    }

    @Override
    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    @Override
    public int getCopiasTotales() {
        return copias_totales;
    }

    @Override
    public void setCopiasTotales(int copiasTotales) {
        this.copias_totales = copiasTotales;
    }

    @Override
    public String getIsbn() {
        return isbn;
    }

    @Override
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String getLibroVirtual() {
        return libro_virtual;
    }

    @Override
    public void setLibroVirtual(String libroVirtual) {
        this.libro_virtual = libroVirtual;
    }

    @Override
    public String getLibroFisico() {
        return libro_fisico;
    }

    @Override
    public void setLibroFisico(String libroFisico) {
        this.libro_fisico = libroFisico;
    }

    @Override
    public String getEditorial() {
        return editorial;
    }

    @Override
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    @Override
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /*
    // Método estático de fábrica utilizando LibroManager
    public static LibroConcreto crearNuevoLibro(String titulo, String review, String disponible,
            int copiasTotales, String isbn, String autor, String libroVirtualId,
            String libroFisicoId, String editorialId, String categoriaId) {
        // Generar un nuevo ID único utilizando UUID
        String nuevoId = UUID.randomUUID().toString();
        return new LibroConcreto(nuevoId, titulo, review, disponible, copiasTotales, isbn, autor,
                libroVirtualId, libroFisicoId, editorialId, categoriaId, "value1", 42);
    }


    // Método privado para generar un nuevo ID (puedes personalizar según tus necesidades)
    private static String generarNuevoId() {
        // Lógica para generar el nuevo ID
        return "ID_GENERADO"; 
    }
*/

}
