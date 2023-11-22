/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

public class ServicioBiblioteca implements ServicioBibliotecaInterface{
    private String multaId;
    private String prestamoId;
    private String membresiaId;
    private String bibliotecarioId;
    private String categoriaId;
    private String libroId;

    // Constructor con parámetros
    public ServicioBiblioteca(String multaId, String prestamoId, String membresiaId,
                              String bibliotecarioId, String categoriaId, String libroId) {
        this.multaId = multaId;
        this.prestamoId = prestamoId;
        this.membresiaId = membresiaId;
        this.bibliotecarioId = bibliotecarioId;
        this.categoriaId = categoriaId;
        this.libroId = libroId;
    }

    // Constructor vacío
    public ServicioBiblioteca() {
        
    }
    
    // Implementación de métodos de la interfaz
    @Override
    public Multa obtenerMulta() {
        // Implementación para obtener la multa asociada
        return null; // Puedes personalizar la lógica según tus necesidades
    }

    @Override
    public Prestamo obtenerPrestamo() {
        // Implementación para obtener el préstamo asociado
        return null; // Puedes personalizar la lógica según tus necesidades
    }

    @Override
    public Membresia obtenerMembresia() {
        // Implementación para obtener la membresía asociada
        return null; // Puedes personalizar la lógica según tus necesidades
    }

    @Override
    public Bibliotecario obtenerBibliotecario() {
        // Implementación para obtener el bibliotecario asociado
        return null; // Puedes personalizar la lógica según tus necesidades
    }

    @Override
    public Categoria obtenerCategoria() {
        // Implementación para obtener la categoría asociada
        return null; // Puedes personalizar la lógica según tus necesidades
    }

    @Override
    public Libro obtenerLibro() {
        // Implementación para obtener el libro asociado
        return null; // Puedes personalizar la lógica según tus necesidades
    }

    // Método toString para imprimir información útil
    @Override
    public String toString() {
        return "ServicioBiblioteca{" +
                "multaId='" + multaId + '\'' +
                ", prestamoId='" + prestamoId + '\'' +
                ", membresiaId='" + membresiaId + '\'' +
                ", bibliotecarioId='" + bibliotecarioId + '\'' +
                ", categoriaId='" + categoriaId + '\'' +
                ", libroId='" + libroId + '\'' +
                '}';
    }
}


