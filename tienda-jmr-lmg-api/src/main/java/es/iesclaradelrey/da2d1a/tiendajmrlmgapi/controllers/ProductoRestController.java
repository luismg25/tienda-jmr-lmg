package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.controllers;

import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto.ProductoDTO;
import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.services.ProductoApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products" )
public class ProductoRestController {

    private final ProductoApiService productoApiService;
    public ProductoRestController(ProductoApiService productoApiService) {
        this.productoApiService = productoApiService;
    }

    // GET /api/v1/products -- listado de todos los productos en orden alfabético
    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listAll() {
        return ResponseEntity.ok(productoApiService.findAll());
    }
}
