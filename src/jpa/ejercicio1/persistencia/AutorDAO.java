/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.ejercicio1.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.ejercicio1.entidades.Autor;
import static jpa.ejercicio1.entidades.Autor_.nombre;

/**
 *
 * @author Naksuke
 */
public final class AutorDAO extends DAO <Autor> {

    @Override
    public void guardar(Autor objeto) {
        super.guardar(objeto); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void editar(Autor autor) {
        super.editar(autor);
    }
    
    public List<Autor> buscarPorNombree(String nombre) {
        try {
            super.conectar();
            List<Autor> autores=em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre").setParameter("nombre", nombre).getResultList();
            return autores;
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }
}
