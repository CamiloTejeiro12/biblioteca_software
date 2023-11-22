/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.bibliotecario;

/**
 *
 * @author tejei
 */

import com.biblioteca.persona.Persona;

public class Bibliotecario implements BibliotecarioInterface {
    private String tarjeta;
    private String persona; 

    // Constructor con parámetros
    public Bibliotecario(String tarjeta, String persona) {
        this.tarjeta = tarjeta;
        this.persona = persona;
    }

    // Constructor vacío
    public Bibliotecario() {

    }

    // Implementación de métodos de la interfaz
    @Override
    public void realizarOperacion() {
        // Implementación específica de la operación del bibliotecario
        System.out.println("Operación realizada por el bibliotecario");
    }

    @Override
    public void otraOperacion() {
        // Implementación específica de otra operación del bibliotecario
        System.out.println("Otra operación realizada por el bibliotecario");
    }

    // Método toString para imprimir información útil
    @Override
    public String toString() {
        return "Bibliotecario{" +
                "tarjeta='" + tarjeta + '\'' +
                ", persona='" + persona + '\'' +
                '}';
    }
}

