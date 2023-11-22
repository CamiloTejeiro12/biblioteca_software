/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biblioteca.pago;

/**
 *
 * @author tejei
 */
import java.util.List;

public interface PagoInterface {
    void agregarPago(Pago pago);
    void eliminarPago(String idPrestamo, String idUsuario);
    List<Pago> obtenerPagosPorUsuario(String idUsuario);
    List<Pago> obtenerPagosPorPrestamo(String idPrestamo);
    List<Pago> obtenerTodosLosPagos();
}
