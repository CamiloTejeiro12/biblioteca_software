/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.libro;

import com.biblioteca.CRUD.GenericDAO;
import com.biblioteca.persona.Persona;
import java.sql.Connection;

/**
 *
 * @author tejei
 */
public class LibroFisicoDAO extends GenericDAO<LibroFisico> {
    public LibroFisicoDAO(Connection connection) {
        super(connection);
    }
}
