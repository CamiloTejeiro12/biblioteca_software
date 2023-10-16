package com.bilioteca.biblioteca;
import java.util.UUID;

public class Usuario extends Persona {
    private String nombreUsuario;
    private String contraseña;

    public Usuario() {
        // Constructor vacío
    }

    public Usuario(String cedula, String nombre, String direccion, String nombreUsuario, String contraseña) {
        super(cedula, nombre, direccion);
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}
