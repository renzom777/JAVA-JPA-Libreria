/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.ejercicio1.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Naksuke
 */
public abstract class DAO<T> {
    
    protected final EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa-ejercicio1PU");
    protected EntityManager em=emf.createEntityManager();
    
    protected void conectar() {
        if (!em.isOpen()) {
            em=emf.createEntityManager();
        }
    }
    
    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }
    
    protected void guardar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    protected void editar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    protected void eliminar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
}
