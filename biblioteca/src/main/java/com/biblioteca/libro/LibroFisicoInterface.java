/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biblioteca.libro;

/**
 *
 * @author tejei
 */
public interface LibroFisicoInterface {

    String getId();

    void setId(String id);

    String getUbicacion();

    void setUbicacion(String ubicacion);

    String getEstado();

    void setEstado(String estado);
    
    public String toString();
}