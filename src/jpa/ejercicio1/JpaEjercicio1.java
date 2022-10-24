/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.ejercicio1;

import java.util.Scanner;
import jpa.ejercicio1.persistencia.AutorDAO;
import jpa.ejercicio1.servicios.AutorServicio;
import jpa.ejercicio1.servicios.EditorialServicio;
import jpa.ejercicio1.servicios.LibroServicio;

public class JpaEjercicio1 {

    public static void main(String[] args) throws Exception {

        Scanner leer = new Scanner(System.in);
        AutorServicio auserv = new AutorServicio();
        AutorDAO audao = new AutorDAO();
        LibroServicio libserv = new LibroServicio();
        EditorialServicio edserv = new EditorialServicio();

        int opcion;
        do {
            System.out.println("\n----------------------------------------"
                    + "\nLIBRERIA"
                    + "\n---------------------"
                    + "\n1. Agregar libro"
                    + "\n2. Modificar titulo de libro"
                    + "\n3. Dar de baja un libro"
                    + "\n4. Dar de alta un libro"
                    + "\n5. Buscar libros por titulo"
                    + "\n6. Buscar libros por autor"
                    + "\n7. Buscar libros por editorial"
                    + "\n8. Agregar autor"
                    + "\n9. Modificar nombre de autor"
                    + "\n10. Dar de alta un autor"
                    + "\n11. Dar de baja un autor"
                    + "\n12. Buscar autor por nombre"
                    + "\n13. Agregar editorial"
                    + "\n14. Modificar nombre de editorial"
                    + "\n15. Dar de alta editorial"
                    + "\n16. Dar de baja editorial"
                    + "\n17. Buscar editorial por nombre"
                    + "\n18. Salir");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingresar titulo");
                    String titulo = leer.next();
                    System.out.println("Ingresar año");
                    Integer anio = leer.nextInt();
                    System.out.println("Ingresar ejemplares");
                    Integer ejemplares = leer.nextInt();
                    System.out.println("Ingresar ejemplares prestados");
                    Integer ejeplaresPrestados = leer.nextInt();
                    System.out.println("Ingresar nombre de autor");
                    String nombreAutor1 = leer.next();
                    System.out.println("Ingresar nombre de editorial");
                    String nombreEditorial1 = leer.next();
                    libserv.crearLibro(anio, ejemplares, ejeplaresPrestados, titulo, nombreAutor1, nombreEditorial1);
                    break;
                case 2:
                    System.out.println("Ingresar titulo del libro a modificar");
                    String tituloViejo = leer.next();
                    System.out.println("Ingresar nuevo titulo");
                    String tituloNuevo = leer.next();
                    libserv.modificarTitulo(tituloViejo, tituloNuevo);
                    break;
                case 3:
                    System.out.println("Ingresar titulo");
                    String tituloBaja = leer.next();
                    libserv.darDeBaja(tituloBaja);
                    break;
                case 4:
                    System.out.println("Ingresar titulo");
                    String tituloAlta = leer.next();
                    libserv.darDeBaja(tituloAlta);
                    break;
                case 5:
                    System.out.println("Ingresar titulo");
                    String tituloBusqueda = leer.next();
                    libserv.buscarPorTitulo(tituloBusqueda);
                    break;
                case 6:
                    System.out.println("Ingresar autor");
                    String autor6 = leer.next();
                    libserv.buscarPorAutor(autor6);
                    break;
                case 7:
                    System.out.println("Ingresar editorial");
                    String editorial7 = leer.next();
                    libserv.buscarPorEditorial(editorial7);
                    break;
                case 8:
                    System.out.println("Ingresar nombre del autor");
                    String nombreAutor8 = leer.next();
                    auserv.crearAutor(nombreAutor8);
                    break;
                case 9:
                    System.out.println("Ingresar nombre de autor a modificar");
                    String nombreViejo9 = leer.next();
                    System.out.println("Ingresar nuevo nombre");
                    String nombreNuevo9 = leer.next();
                    auserv.modificarNombre(nombreViejo9, nombreNuevo9);
                    break;
                case 10:
                    System.out.println("Ingresar autor");
                    String autor10 = leer.next();
                    auserv.darDeAlta(autor10);
                    break;
                case 11:
                    System.out.println("Ingresar autor");
                    String autor11 = leer.next();
                    auserv.darDeBaja(autor11);
                    break;
                case 12:
                    System.out.println("Ingresar autor");
                    String autor12 = leer.next();
                    auserv.buscarPorNombre(autor12);
                    break;
                case 13:
                    System.out.println("Ingresar nombre de la editorial");
                    String nombreEditorial = leer.next();
                    edserv.crearEditorial(nombreEditorial);
                    break;
                case 14:
                    System.out.println("Ingresar nombre de editorial a modificar");
                    String nombreViejo14 = leer.next();
                    System.out.println("Ingresar nuevo nombre");
                    String nombreNuevo14 = leer.next();
                    edserv.modificarNombre(nombreViejo14, nombreNuevo14);
                    break;
                case 15:
                    System.out.println("Ingresar editorial");
                    String editorial5 = leer.next();
                    edserv.darDeAlta(editorial5);
                    break;
                case 16:
                    System.out.println("Ingresar editorial");
                    String editorial6 = leer.next();
                    edserv.darDeBaja(editorial6);
                    break;
                case 17:
                    System.out.println("Ingresar nombre de la editorial");
                    String nombreEditorial17 = leer.next();
                    edserv.buscarPorNombre(nombreEditorial17);
                    break;
            }
        } while (opcion != 18);
    }
}
