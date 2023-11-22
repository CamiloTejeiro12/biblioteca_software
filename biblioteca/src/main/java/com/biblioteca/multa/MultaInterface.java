/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biblioteca.multa;

/**
 *
 * @author tejei
 */
import java.util.Date;
import java.util.List;

public interface MultaInterface {
    public String getId();
    public void setId(String id);
    public float getMonto();
    public void setMonto(float monto);
    public String getDescripcion();
    public void setDescripcion(String descripcion);
    public Date getFechaVencimiento();
    public void setFechaVencimiento( Date fechaVencimiento);
    public String toString();
}
