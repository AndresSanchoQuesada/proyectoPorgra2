package domain;
//Declaracion de librerias adicionales

import java.io.Serializable;
import java.util.ArrayList;

public class ForHire implements Serializable {

    private ArrayList<Book> a;  // arreglo de objetos para empleados
//Generacion del Constructor

    public ForHire() {
        a = new ArrayList();// crea el objeto
    }
// metodos de administracion del arreglo
    // adiciona un nuevo Libro
    // obtiene un Libro

    public Book getLibro(int i) {
        return a.get(i);
    }
    // reemplaza un informacion de un libro

    public void reemplaza(int i, Book actualizado) {
        a.set(i, actualizado);
    }
    // elimina un libro

    public void elimina(int i) {
        a.remove(i);
    }
    // elimina a todos los libros

    public void elimina() {
        for (int i = 0; i < numeroLibros(); i++) {
            a.remove(0);
        }
    }
    // obtiene numero de libros registrado

    public int numeroLibros() {
        return a.size();
    }

    // busca un libroo por codigo
    public int busca(String codigo) {
        for (int i = 0; i < numeroLibros(); i++) {
            if (codigo.equalsIgnoreCase(getLibro(i).getCodBook())) {
                return i; // retorna indice
            }
        }
        return -1; // significa que no lo encontró
    }
}
