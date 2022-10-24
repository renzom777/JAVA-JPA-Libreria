/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.ejercicio1.servicios;

import java.util.List;
import jpa.ejercicio1.entidades.Autor;
import jpa.ejercicio1.entidades.Editorial;
import jpa.ejercicio1.entidades.Libro;
import jpa.ejercicio1.persistencia.AutorDAO;
import jpa.ejercicio1.persistencia.DAO;
import jpa.ejercicio1.persistencia.EditorialDAO;
import jpa.ejercicio1.persistencia.LibroDAO;

public class LibroServicio {
    
    private LibroDAO libroDao;
    private AutorDAO autorDao;
    private EditorialDAO editorialDao;

    public LibroServicio() {
        this.libroDao = new LibroDAO();
        this.autorDao = new AutorDAO();
        this.editorialDao = new EditorialDAO();
    }
    
    public void crearLibro(Integer anio, Integer ejemplares, Integer ejemplaresPrestados, String titulo, String nombreAutor, String nombreEditorial) throws Exception {
        try {
            List <Autor> autores=autorDao.buscarPorNombree(nombreAutor);
            Autor autor=autores.get(0);
            List <Editorial> editoriales=editorialDao.buscarPorNombree(nombreEditorial);
            Editorial editorial=editoriales.get(0);
            Integer ejemplaresRestantes=ejemplares-ejemplaresPrestados;
            Libro libro=new Libro();
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(ejemplaresPrestados);
            libro.setEjemplaresRestantes(ejemplaresRestantes);
            libro.setAlta(true);
            libroDao.guardar(libro);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarTitulo(String tituloViejo, String tituloNuevo) {
        try {
            List <Libro> libros = libroDao.buscarPorTitulo(tituloViejo);
            Libro libro=libros.get(0);
            libro.setTitulo(tituloNuevo);
            libroDao.editar(libro);
        } catch (Exception e) {
            throw e;
        }
    }

    public void darDeAlta(String titulo) {
        try {
            List <Libro> libros = libroDao.buscarPorTitulo(titulo);
            Libro libro=libros.get(0);
            if (!libro.isAlta()) {
                libro.setAlta(true);
            } else {
                System.out.println("Este libro ya está dado de alta");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void darDeBaja(String titulo) {
        try {
            List <Libro> libros = libroDao.buscarPorTitulo(titulo);
            Libro libro=libros.get(0);
            if (libro.isAlta()) {
                libro.setAlta(false);
            } else {
                System.out.println("Este libro ya está dado de baja");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void buscarPorTitulo(String titulo) throws Exception {
        try {
            List<Libro> libros=libroDao.buscarPorTitulo(titulo);
//            if (autor==null) {
//                throw new Exception ("Este autor no existe en la base");
//            }
            for (Libro aux : libros) {
                System.out.println(aux);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void buscarPorAutor(String nombreAutor) throws Exception {
        try {
            List<Libro> libros=libroDao.buscarPorAutor(nombreAutor);
//            if (autor==null) {
//                throw new Exception ("Este autor no existe en la base");
//            }
//            for (Libro aux : libros) {
//                System.out.println(aux);
//            }
// para que aparezcan solo los nombres
            for (Libro aux : libros) {
                System.out.println(aux.getTitulo());
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void buscarPorEditorial(String nombreEditorial) throws Exception {
        try {
            List<Libro> libros=libroDao.buscarPorAutor(nombreEditorial);
//            if (autor==null) {
//                throw new Exception ("Este autor no existe en la base");
//            }
//            for (Libro aux : libros) {
//                System.out.println(aux);
//            }
// para que aparezcan solo los nombres
            for (Libro aux : libros) {
                System.out.println(aux.getTitulo());
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
}
