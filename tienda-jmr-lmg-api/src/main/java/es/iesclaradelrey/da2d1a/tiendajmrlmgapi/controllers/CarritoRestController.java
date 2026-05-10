package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.controllers;

import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto.AddProductoRequestDTO;
import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto.CarritoResumenDTO;
import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.services.CarritoApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
public class CarritoRestController {
    private final CarritoApiService carritoApiService;

    public CarritoRestController(CarritoApiService carritoApiService) {
        this.carritoApiService = carritoApiService;
    }

    @GetMapping
    public ResponseEntity<CarritoResumenDTO> getCarrito() {
        return ResponseEntity.ok(carritoApiService.getResumenCarrito());
    }

    @PostMapping
    public ResponseEntity<CarritoResumenDTO> addProducto(@RequestBody AddProductoRequestDTO request) {
        return ResponseEntity.ok(carritoApiService.addProducto(request.getProductoId(), request.getUnidades()));
    }

    @DeleteMapping("/{productid}")
    public ResponseEntity<CarritoResumenDTO> removeProducto(@PathVariable("productid") Long productId) {
        return ResponseEntity.ok(carritoApiService.removeProducto(productId));
    }

    @DeleteMapping
    public ResponseEntity<CarritoResumenDTO> emptyCarrito() {
        return ResponseEntity.ok(carritoApiService.emptyCarrito());
    }
}