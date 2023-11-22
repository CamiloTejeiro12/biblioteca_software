/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.pago;

import com.biblioteca.usuario.Usuario;
import com.biblioteca.prestamo.Prestamo;

/**
 *
 * @author tejei
 */
import java.util.List;

public class Pago implements PagoInterface {
    private String idPrestamo;
    private String idUsuario;

    // Constructores, getters y setters

    public Pago() {
        // Constructor vacío
    }

    public Pago(String idPrestamo, String idUsuario) {
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
    }

    // Getters y setters para cada atributo

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Pago [idPrestamo=" + idPrestamo + ", idUsuario=" + idUsuario + "]";
    }

    // Implementación de los métodos de la interfaz

    @Override
    public void agregarPago(Pago pago) {
        // Lógica para agregar un pago a la base de datos
    }

    @Override
    public void eliminarPago(String idPrestamo, String idUsuario) {
        // Lógica para eliminar un pago de la base de datos
    }

    @Override
    public List<Pago> obtenerPagosPorUsuario(String idUsuario) {
        // Lógica para obtener pagos por usuario de la base de datos
        return null; // Reemplaza con la implementación real
    }

    @Override
    public List<Pago> obtenerPagosPorPrestamo(String idPrestamo) {
        // Lógica para obtener pagos por préstamo de la base de datos
        return null; // Reemplaza con la implementación real
    }

    @Override
    public List<Pago> obtenerTodosLosPagos() {
        // Lógica para obtener todos los pagos de la base de datos
        return null; // Reemplaza con la implementación real
    }
}
