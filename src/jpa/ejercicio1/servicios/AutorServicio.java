/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.ejercicio1.servicios;

import java.util.List;
import jpa.ejercicio1.entidades.Autor;
import jpa.ejercicio1.persistencia.AutorDAO;

public class AutorServicio {

    private AutorDAO dao;

    public AutorServicio() {
        this.dao = new AutorDAO();
    }

    public void crearAutor(String nombre) {

        try {
            Autor autor = new Autor();
            autor.setNombre(nombre);
            autor.setAlta(true);
            dao.guardar(autor);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarNombre(String nombreViejo, String nombreNuevo) {
        try {
            List <Autor> autores = dao.buscarPorNombree(nombreViejo);
            Autor autor=autores.get(0);
            autor.setNombre(nombreNuevo);
            dao.editar(autor);
        } catch (Exception e) {
            throw e;
        }
    }

    public void darDeAlta(String nombre) {
        try {
            List <Autor> autores = dao.buscarPorNombree(nombre);
            Autor autor=autores.get(0);
            if (!autor.isAlta()) {
                autor.setAlta(true);
            } else {
                System.out.println("Este autor ya está dado de alta");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void darDeBaja(String nombre) {
        try {
            List <Autor> autores = dao.buscarPorNombree(nombre);
            Autor autor=autores.get(0);
            if (autor.isAlta()) {
                autor.setAlta(false);
            } else {
                System.out.println("Este autor ya está dado de baja");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void buscarPorNombre(String nombre) throws Exception {
        try {
            List<Autor> autores=dao.buscarPorNombree(nombre);
//            if (autor==null) {
//                throw new Exception ("Este autor no existe en la base");
//            }
            for (Autor autore : autores) {
                System.out.println(autore);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
}
