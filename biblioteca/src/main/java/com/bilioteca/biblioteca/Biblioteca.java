package com.bilioteca.biblioteca;


import com.bilioteca.libro.Editorial;
import com.bilioteca.libro.LibroFisico;
import com.bilioteca.libro.Libro;
import com.bilioteca.libro.*;
import com.bilioteca.libro.LibroVirtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


public class Biblioteca {

    public static void main(String[] args) {
        // Crear una instancia de LibroVirtual y LibroFisico para utilizar en las pruebas
        LibroVirtual libroVirtual = new LibroVirtual(UUID.randomUUID(), "marcadoUsuario", "formatoElectronico", "resumen", "tamanoArchivo");
        LibroFisico libroFisico = new LibroFisico(UUID.randomUUID(), "ubicacion", "estado");
        // Crear una instancia de Editorial y Categoria para utilizar en las pruebas
        Editorial editorial = new Editorial(UUID.randomUUID(), "CasaBlanca");
        Categoria categoria = new Categoria(UUID.randomUUID(), "Accion");

        // Crear una instancia de Libro para probar los métodos
        Libro libro = new Libro(UUID.randomUUID(), "Título del libro", "Review del libro", "Disponible", 10, "ISBN12345", "Autor del libro", libroVirtual, libroFisico, editorial, categoria);
        // Probar los métodos de la clase Libro
        System.out.println("ID del libro: " + libro.getId());
        System.out.println("Título del libro: " + libro.getTitulo());
        System.out.println("Review del libro: " + libro.getReview());
        System.out.println("Disponible: " + libro.getDisponible());
        System.out.println("Número total de copias: " + libro.getCopiasTotales());
        System.out.println("ISBN del libro: " + libro.getIsbn());
        System.out.println("Autor del libro: " + libro.getAutor());

        libro.setLibroVirtual(libroVirtual);
        libro.setLibroFisico(libroFisico);
        System.out.println("Libro virtual: " + libro.getLibroVirtual());
        System.out.println("Libro físico: " + libro.getLibroFisico());

        libro.asignarEditorial(editorial);
        libro.asignarCategoria(categoria);
        System.out.println("Editorial: " + libro.getEditorial());
        System.out.println("Categoría: " + libro.getCategoria());
    }
}