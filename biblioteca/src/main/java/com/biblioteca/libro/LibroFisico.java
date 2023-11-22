/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.libro;

/**
 *
 * @author tejei
 */
public class LibroFisico implements LibroFisicoInterface {

    private String id;
    private String ubicacion;
    private String estado;
    
    public LibroFisico(){
        
    }

    public LibroFisico(String id, String ubicacion, String estado) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }
    

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String getEstado() {
        return estado;
    }

    @Override
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "LibroFisico{id=" + id + ", ubicacion=" + ubicacion + ", estado=" + estado + '}';
    }
}
