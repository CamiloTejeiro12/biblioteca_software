/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.libro;

/**
 *
 * @author tejei
 */

public class LibroVirtual implements LibroVirtualInterface {

    private String id;
    private String marcadoUsuario;
    private String formatoElectronico;
    private String resumen;
    private String tamanoArchivo;

    public LibroVirtual(String id, String marcadoUsuario, String formatoElectronico, String resumen, String tamanoArchivo) {
        this.id = id;
        this.marcadoUsuario = marcadoUsuario;
        this.formatoElectronico = formatoElectronico;
        this.resumen = resumen;
        this.tamanoArchivo = tamanoArchivo;
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
    public String getMarcadoUsuario() {
        return marcadoUsuario;
    }

    @Override
    public void setMarcadoUsuario(String marcadoUsuario) {
        this.marcadoUsuario = marcadoUsuario;
    }

    @Override
    public String getFormatoElectronico() {
        return formatoElectronico;
    }

    @Override
    public void setFormatoElectronico(String formatoElectronico) {
        this.formatoElectronico = formatoElectronico;
    }

    @Override
    public String getResumen() {
        return resumen;
    }

    @Override
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    @Override
    public String getTamanoArchivo() {
        return tamanoArchivo;
    }

    @Override
    public void setTamanoArchivo(String tamanoArchivo) {
        this.tamanoArchivo = tamanoArchivo;
    }
}
