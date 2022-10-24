/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.ejercicio1.persistencia;

import java.util.List;
import jpa.ejercicio1.entidades.Libro;

public final class LibroDAO extends DAO<Libro> {
    
    @Override
    public void guardar(Libro libro) {
        super.guardar(libro); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void editar(Libro libro) {
        super.editar(libro);
    }
    
    public List<Libro> buscarPorTitulo(String titulo) {
        try {
            super.conectar();
            List<Libro> libros=em.createQuery("SELECT a FROM Libro a WHERE a.titulo LIKE :titulo").setParameter("titulo", titulo).getResultList();
            return libros;
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }
    
    public List<Libro> buscarPorAutor(String nombreAutor) {
        try {
            super.conectar();
            List<Libro> libros=em.createQuery("SELECT a FROM Libro a WHERE a.autor.nombre LIKE :nombreAutor").setParameter("nombreAutor", nombreAutor).getResultList();
            return libros;
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }
    
    public List<Libro> buscarPorEditorial(String nombreEditorial) {
        try {
            super.conectar();
            List<Libro> libros=em.createQuery("SELECT a FROM Libro a WHERE a.editorial.nombre LIKE :nombreEditorial").setParameter("nombreEditorial", nombreEditorial).getResultList();
            return libros;
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }
}
