/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilioteca.libro;

/**
 *
 * @author tejei
 */
import java.util.UUID;

public class LibroVirtual implements InterfaceLibroVirtual {
    private UUID id;
    private String marcadoUsuario;
    private String formatoElectronico;
    private String resumen;
    private String tamanoArchivo;

    public LibroVirtual(UUID id, String marcadoUsuario, String formatoElectronico, String resumen, String tamanoArchivo) {
        this.id = id;
        this.marcadoUsuario = marcadoUsuario;
        this.formatoElectronico = formatoElectronico;
        this.resumen = resumen;
        this.tamanoArchivo = tamanoArchivo;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String getMarcadoUsuario() {
        return marcadoUsuario;
    }

    public void setMarcadoUsuario(String marcadoUsuario) {
        this.marcadoUsuario = marcadoUsuario;
    }

    @Override
    public String getFormatoElectronico() {
        return formatoElectronico;
    }

    public void setFormatoElectronico(String formatoElectronico) {
        this.formatoElectronico = formatoElectronico;
    }

    @Override
    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    @Override
    public String getTamanoArchivo() {
        return tamanoArchivo;
    }

    public void setTamanoArchivo(String tamanoArchivo) {
        this.tamanoArchivo = tamanoArchivo;
    }

    // Métodos específicos para libros virtuales
    public void cargarArchivo() {
        // Implementación para cargar el archivo virtual
    }
}
