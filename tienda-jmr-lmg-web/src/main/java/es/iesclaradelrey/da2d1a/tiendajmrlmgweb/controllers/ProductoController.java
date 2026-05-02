package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.controllers;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.ProductoService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// Gestiona los productos
@Controller
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService productoService;
    public ProductoController(ProductoService ps) { this.productoService = ps; }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Producto producto = productoService.findById(id).orElse(null);
        if (producto == null) return "redirect:/productos";

        model.addAttribute("producto", producto);
        return "productos/detalle";
    }
}