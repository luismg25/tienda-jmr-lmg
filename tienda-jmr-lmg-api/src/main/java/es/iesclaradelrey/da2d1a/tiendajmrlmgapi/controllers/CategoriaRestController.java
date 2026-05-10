package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.controllers;

import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto.CategoriaDTO;
import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto.ProductoDTO;
import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.services.CategoriaApiService;
import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.services.ProductoApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriaRestController {

    private final CategoriaApiService categoriaApiService;
    private final ProductoApiService productoApiService;
    public CategoriaRestController(CategoriaApiService categoriaApiService,
                                   ProductoApiService productoApiService) {
        this.categoriaApiService = categoriaApiService;
        this.productoApiService = productoApiService;
    }

    // GET /api/v1/categories -- listado de categorías en orden alfabético
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listAll() {
        return ResponseEntity.ok(categoriaApiService.findAll());
    }
    //GET /api/v1/categories/{categoryId}/products - productos de una categoría
    @GetMapping("/{categoryId}/products")
    public ResponseEntity<List<ProductoDTO>> productsByCategory(
            @PathVariable Long categoryId) {
        return ResponseEntity.ok(productoApiService.findByCategoria(categoryId));
    }
}
