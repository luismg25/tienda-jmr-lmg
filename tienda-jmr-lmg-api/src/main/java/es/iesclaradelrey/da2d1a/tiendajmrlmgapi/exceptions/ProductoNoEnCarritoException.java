package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.exceptions;

public class ProductoNoEnCarritoException extends RuntimeException {
    public ProductoNoEnCarritoException(Long id) {
        super("El producto con ID " + id + " no está en tu carrito.");
    }
}