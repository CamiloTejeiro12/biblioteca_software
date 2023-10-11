/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bilioteca.libro;

/**
 *
 * @author tejei
 */
import java.util.UUID;

public interface InterfaceCategoria {
    UUID getId();
    String getDescripcion();

    void setId(UUID id);
    void setDescripcion(String descripcion);
}
