/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.reserva;

/**
 *
 * @author tejei
 */

import com.biblioteca.usuario.Usuario;

public class Reserva implements ReservaInterface {
    private String id;
    private java.sql.Date fechaReserva;
    private Usuario usuario;

    // Constructor con parámetros
    public Reserva(String id, java.sql.Date fechaReserva, Usuario usuario) {
        this.id = id;
        this.fechaReserva = fechaReserva;
        this.usuario = usuario;
    }

    // Constructor vacío
    public Reserva() {

    }

    // Implementación de métodos de la interfaz
    @Override
    public void realizarReserva() {
        // Implementación específica de la reserva
        System.out.println("Reserva realizada");
    }

    @Override
    public void cancelarReserva() {
        // Implementación específica de la cancelación de la reserva
        System.out.println("Reserva cancelada");
    }

    // Método toString para imprimir información útil
    @Override
    public String toString() {
        return "Reserva{" +
                "id='" + id + '\'' +
                ", fechaReserva=" + fechaReserva +
                ", usuario=" + usuario +
                '}';
    }
}

