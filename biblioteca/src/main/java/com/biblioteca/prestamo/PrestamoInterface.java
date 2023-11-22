/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biblioteca.prestamo;

/**
 *
 * @author tejei
 */
import java.util.List;

public interface PrestamoInterface {
    void agregarPrestamo(Prestamo prestamo);
    void actualizarPrestamo(Prestamo prestamo);
    void eliminarPrestamo(String id);
    Prestamo obtenerPrestamoPorId(String id);
    List<Prestamo> obtenerTodosLosPrestamos();
}

