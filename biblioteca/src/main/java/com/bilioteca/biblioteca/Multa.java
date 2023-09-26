/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilioteca.biblioteca;

/**
 *
 * @author tejei
 */
import java.util.ArrayList;
import java.util.List;

public class Multa {

    // Lista para almacenar objetos Multa
    private static List<Multa> multas = new ArrayList<>();

    // Atributos de la clase
    private int id;
    private float monto;
    private String descripcion;
    private String fechaVencimiento;

    // Constructor
    public Multa(int id, float monto, String descripcion, String fechaVencimiento) {
        this.id = id;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    // Método para insertar una multa en la lista
    public void insertarMulta(Multa multa) {
        multas.add(multa);
    }

    // Método para consultar una multa por su ID
    public Multa consultarMultaPorId(int id) {
        for (Multa multa : multas) {
            if (multa.id == id) {
                return multa;
            }
        }
        return null; // Si no se encuentra la multa
    }

    // Método para actualizar los datos de una multa
    public void actualizarMulta(Multa multa) {
        int index = multas.indexOf(multa);
        if (index != -1) {
            multas.set(index, multa);
        } else {
            System.out.println("La multa no existe en la lista.");
        }
    }

    // Método para eliminar una multa de la lista
    public void eliminarMulta(Multa multa) {
        multas.remove(multa);
    }

    // Otros métodos getters y setters, si es necesario
}
