package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.controllers;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // GET /categorias  →  muestra el listado
    @GetMapping
    public String list(Model model) {
        // Model es donde meto los datos para pasarlos a la vista
        model.addAttribute("categorias", categoriaService.findAll());
        // Devuelve la plantilla templates/categorias/list.html
        return "categorias/list";
    }

    // GET /categorias/2 : muestra el detalle de la categoría con id=2
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<Categoria> categoria = categoriaService.findById(id);

        if (categoria.isEmpty()) {
            // Si no existe esa categoría te lleva al listado
            return "redirect:/categorias";
        }
        //Devuelve segun id, la categoria unica la pasa a la vista:
        model.addAttribute("categoria", categoria.get());
        return "categorias/detail";
    }
}
