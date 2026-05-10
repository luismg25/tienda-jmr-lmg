package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.exceptions;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException(String nombre) {
        super("No se ha encontrado la categoria: " + nombre);
    }
}