package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.exceptions;

public class ProductoNotFoundException extends RuntimeException {
    public ProductoNotFoundException(Long id) {
        super("No se ha encontrado el producto con ID: " + id);
    }
}