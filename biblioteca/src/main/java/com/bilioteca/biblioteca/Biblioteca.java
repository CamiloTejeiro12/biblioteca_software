package com.bilioteca.biblioteca;

import java.sql.Connection;
import conexioDataBase.ConexionBD;

public class Biblioteca {

    public static void main(String[] args) {
        ConexionBD conexionBD = new ConexionBD();
        
        // Obtener una conexión
        Connection conexion = conexionBD.conectar();
        
        // Verificar si la conexión es nula (hubo un problema)
        if (conexion == null) {
            System.out.println("No se pudo establecer la conexión.");
            return; // Puedes manejar el error según tus necesidades
        }
    }
}
