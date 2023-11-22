/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biblioteca.libro;

/**
 *
 * @author tejei
 */
public interface LibroVirtualInterface {

    String getId();

    void setId(String id);

    String getMarcadoUsuario();

    void setMarcadoUsuario(String marcadoUsuario);

    String getFormatoElectronico();

    void setFormatoElectronico(String formatoElectronico);

    String getResumen();

    void setResumen(String resumen);

    String getTamanoArchivo();

    void setTamanoArchivo(String tamanoArchivo);
}
