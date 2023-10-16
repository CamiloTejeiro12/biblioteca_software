/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bilioteca.biblioteca;

public interface PersonaRepository {
    void crearPersona(Persona persona);
    Persona buscarPersonaPorCedula(String cedula);
    void actualizarPersona(Persona persona);
    void eliminarPersona(String cedula);
}

