/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.persona;

/**
 *
 * @author tejei
 */
import java.sql.Connection;
import com.biblioteca.CRUD.GenericDAO;

public class PersonaDAO extends GenericDAO<Persona> {

    public PersonaDAO(Connection connection) {
        super(connection);
    }
}
