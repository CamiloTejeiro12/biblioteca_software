/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.prestamo;

/**
 *
 * @author tejei
 */
import java.util.Date;

public class Prestamo {
    private String id;
    private Date fechaPrestamo;
    private Date fechaDevolucionPrevista;
    private Date fechaDevolucion;

    // Constructores, getters y setters

    public Prestamo() {
        // Constructor vacío
    }

    public Prestamo(String id, Date fechaPrestamo, Date fechaDevolucionPrevista, Date fechaDevolucion) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
        this.fechaDevolucion = fechaDevolucion;
    }

    // Getters y setters para cada atributo

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucionPrevista() {
        return fechaDevolucionPrevista;
    }

    public void setFechaDevolucionPrevista(Date fechaDevolucionPrevista) {
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Prestamo [id=" + id + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucionPrevista=" + fechaDevolucionPrevista + ", fechaDevolucion=" + fechaDevolucion + "]";
    }
}
