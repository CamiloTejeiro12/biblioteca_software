/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.multa;

/**
 *
 * @author tejei
 */
import java.util.Date;



public class Multa implements MultaInterface {
    private String id;
    private float monto;
    private String descripcion;
    private Date fechaVencimiento;

    // Constructores, getters y setters

    public Multa() {
        // Constructor vacío
    }

    public Multa(String id, float monto, String descripcion, java.sql.Date fechaVencimiento) {
        this.id = id;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
    }

    // Getters y setters para cada atributo

    @Override
    public String getId() {
        return id;
    }
    
    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public float getMonto() {
        return monto;
    }
    
    @Override
    public void setMonto(float monto) {
        this.monto = monto;
    }
    
    @Override
    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }
    
    @Override
    public void setFechaVencimiento( Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Multa [id=" + id + ", monto=" + monto + ", descripcion=" + descripcion + ", fechaVencimiento=" + fechaVencimiento + "]";
    }


}
