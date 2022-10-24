/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.ejercicio1.persistencia;

import java.util.List;
import jpa.ejercicio1.entidades.Autor;
import jpa.ejercicio1.entidades.Editorial;

/**
 *
 * @author Naksuke
 */
public final class EditorialDAO extends DAO<Editorial> {
    
    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void editar(Editorial editorial) {
        super.editar(editorial);
    }
    
    public List<Editorial> buscarPorNombree(String nombre) {
        try {
            super.conectar();
            List<Editorial> editoriales=em.createQuery("SELECT a FROM Editorial a WHERE a.nombre LIKE :nombre").setParameter("nombre", nombre).getResultList();
            return editoriales;
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }
    
}
