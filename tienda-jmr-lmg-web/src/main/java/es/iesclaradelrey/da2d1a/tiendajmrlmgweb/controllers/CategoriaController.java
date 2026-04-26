package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.controllers;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.CategoriaService;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;
    private final ProductoService productoService;

    public CategoriaController(CategoriaService cs, ProductoService ps) {
        this.categoriaService = cs;
        this.productoService = ps;
    }

    // GET /categorias  →  muestra el listado
    @GetMapping
    public String list(Model model) {
        model.addAttribute("categorias", categoriaService.findAll());
        return "categorias/lista";
    }

    // Muestra los productos de UNA categoría específica
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.findById(id).orElse(null);
        if (categoria == null) return "redirect:/categorias";

        model.addAttribute("categoria", categoria);
        model.addAttribute("productos", productoService.findByCategoria(id));
        return "categorias/categoria";
    }
}
