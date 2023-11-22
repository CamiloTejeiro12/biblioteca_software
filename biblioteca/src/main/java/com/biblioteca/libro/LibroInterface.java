/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biblioteca.libro;

import com.biblioteca.categoria.Categoria;

/**
 *
 * @author tejei
 */

public interface LibroInterface {

    String getId();

    void setId(String id);

    String getTitulo();

    void setTitulo(String titulo);

    String getReview();

    void setReview(String review);

    String getDisponible();

    void setDisponible(String disponible);

    int getCopiasTotales();

    void setCopiasTotales(int copiasTotales);

    String getIsbn();

    void setIsbn(String isbn);

    String getAutor();

    void setAutor(String autor);

    String getLibroVirtual();

    void setLibroVirtual(String libroVirtual);

    String getLibroFisico();

    void setLibroFisico(String libroFisico);

    String getEditorial();

    void setEditorial(String editorial);

    String getCategoria();

    void setCategoria(String categoria);
}

