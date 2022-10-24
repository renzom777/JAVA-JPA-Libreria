/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.ejercicio1.servicios;

import java.util.List;
import jpa.ejercicio1.entidades.Editorial;
import jpa.ejercicio1.persistencia.EditorialDAO;

public class EditorialServicio {
    
    private EditorialDAO dao;

    public EditorialServicio() {
        this.dao = new EditorialDAO();
    }
    
    public void crearEditorial(String nombre) {

        try {
            Editorial editorial = new Editorial();
            editorial.setNombre(nombre);
            editorial.setAlta(true);
            dao.guardar(editorial);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarNombre(String nombreViejo, String nombreNuevo) {
        try {
            List <Editorial> editoriales = dao.buscarPorNombree(nombreViejo);
            Editorial editorial=editoriales.get(0);
            editorial.setNombre(nombreNuevo);
            dao.editar(editorial);
        } catch (Exception e) {
            throw e;
        }
    }

    public void darDeAlta(String nombre) {
        try {
            List <Editorial> editoriales = dao.buscarPorNombree(nombre);
            Editorial editorial=editoriales.get(0);
            if (!editorial.isAlta()) {
                editorial.setAlta(true);
            } else {
                System.out.println("Este autor ya está dado de alta");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void darDeBaja(String nombre) {
        try {
            List <Editorial> editoriales = dao.buscarPorNombree(nombre);
            Editorial editorial=editoriales.get(0);
            if (editorial.isAlta()) {
                editorial.setAlta(false);
            } else {
                System.out.println("Este autor ya está dado de baja");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void buscarPorNombre(String nombre) throws Exception {
        try {
            List<Editorial> editoriales=dao.buscarPorNombree(nombre);
//            if (autor==null) {
//                throw new Exception ("Este autor no existe en la base");
//            }
            for (Editorial aux : editoriales) {
                System.out.println(aux);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    
}
