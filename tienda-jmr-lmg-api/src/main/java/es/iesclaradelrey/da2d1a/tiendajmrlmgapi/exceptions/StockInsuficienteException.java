package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.exceptions;

public class StockInsuficienteException extends RuntimeException {
    public StockInsuficienteException(String nombre, int solicitado, int disponible) {
        super(String.format("Stock insuficiente para '%s'. Solicitado: %d, Disponible: %d", nombre, solicitado, disponible));
    }
}