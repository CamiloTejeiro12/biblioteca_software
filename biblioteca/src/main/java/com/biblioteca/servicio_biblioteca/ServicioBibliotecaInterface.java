/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biblioteca.servicio_biblioteca;

/**
 *
 * @author tejei
 */

import com.biblioteca.multa.Multa;
import com.biblioteca.prestamo.Prestamo;
import com.biblioteca.membresia.Membresia;
import com.biblioteca.bibliotecario.Bibliotecario;
import com.biblioteca.categoria.Categoria;
import com.biblioteca.libro.Libro;

public interface ServicioBibliotecaInterface {
    Multa obtenerMulta();
    Prestamo obtenerPrestamo();
    Membresia obtenerMembresia();
    Bibliotecario obtenerBibliotecario();
    Categoria obtenerCategoria();
    Libro obtenerLibro();
}