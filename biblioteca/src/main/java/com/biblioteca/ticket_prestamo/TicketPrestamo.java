/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.ticket_prestamo;

/**
 *
 * @author tejei
 */
public class TicketPrestamo implements TicketPrestamoInterface{
    private String idPrestamo;
    private String idUsuario;

    // Constructores, getters y setters

    public TicketPrestamo() {
        // Constructor vacío
    }

    public TicketPrestamo(String idPrestamo, String idUsuario) {
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
    }

    // Getters y setters para cada atributo

    @Override
    public String getIdPrestamo() {
        return idPrestamo;
    }

    @Override
    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    @Override
    public String getIdUsuario() {
        return idUsuario;
    }

    @Override
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "TicketPrestamo [idPrestamo=" + idPrestamo + ", idUsuario=" + idUsuario + "]";
    }
}

