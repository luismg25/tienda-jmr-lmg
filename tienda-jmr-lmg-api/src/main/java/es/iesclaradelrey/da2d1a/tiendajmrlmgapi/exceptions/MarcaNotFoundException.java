package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.exceptions;

public class MarcaNotFoundException extends RuntimeException {
    public MarcaNotFoundException(String nombre) {
        super("No se ha encontrado la marca: " + nombre);
    }
}