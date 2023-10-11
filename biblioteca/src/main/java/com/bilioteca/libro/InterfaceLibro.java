/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bilioteca.libro;

/**
 *
 * @author tejei
 */
import java.util.UUID;

public interface InterfaceLibro {
    UUID getId();
    String getTitulo();
    String getReview();
    String getDisponible();
    int getCopiasTotales();
    String getIsbn();
    String getAutor();
    LibroVirtual getLibroVirtual();
    LibroFisico getLibroFisico();
    Editorial getEditorial();
    Categoria getCategoria();
}
