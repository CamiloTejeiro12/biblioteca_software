package com.bilioteca.libro;

//import com.bilioteca.biblioteca.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Clase para representar libros
 */
import java.util.UUID;

public class Libro implements InterfaceLibro {
    private UUID id;
    private String titulo;
    private String review;
    private String disponible;
    private int copiasTotales;
    private String isbn;
    private String autor;
    private LibroVirtual libroVirtual;
    private LibroFisico libroFisico;
    private Editorial editorial;
    private Categoria categoria;

    public Libro(UUID id, String titulo, String review, String disponible, int copiasTotales, String isbn, String autor,
                LibroVirtual libroVirtual, LibroFisico libroFisico, Editorial editorial, Categoria categoria) {
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

    
    public Libro(LibroVirtual libroVirtual) {
        this.libroVirtual = libroVirtual;
    }

    @Override
    public UUID getId() {
        return id;
    }

    
    @Override
    public String getTitulo() {
        return titulo;
    }

    
    @Override
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    
    @Override
    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    
    @Override
    public int getCopiasTotales() {
        return copiasTotales;
    }

    public void setCopiasTotales(int copiasTotales) {
        this.copiasTotales = copiasTotales;
    }

    
    @Override
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    
    @Override
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    
    @Override
    public LibroVirtual getLibroVirtual() {
        return libroVirtual;
    }

    public void setLibroVirtual(LibroVirtual libroVirtual) {
        this.libroVirtual = libroVirtual;
    }

    
    @Override
    public LibroFisico getLibroFisico() {
        return libroFisico;
    }

    public void setLibroFisico(LibroFisico libroFisico) {
        this.libroFisico = libroFisico;
    }

    
    @Override
    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    
    @Override
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
