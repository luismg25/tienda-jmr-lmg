package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.controllers;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.CategoriaService;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final ProductoService productoService;

    public CategoriaController(CategoriaService categoriaService, ProductoService productoService) {
        this.categoriaService = categoriaService;
        this.productoService = productoService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("categorias", categoriaService.findAll());
        return "categorias/lista";
    }

    @GetMapping("/{id}")
    public String detail(
            @PathVariable Long id,
            @RequestParam(defaultValue = "nombre") String sortField,
            @RequestParam(defaultValue = "asc") String sortDir,
            Model model) {

        Optional<Categoria> categoriaOpt = categoriaService.findById(id);
        if (categoriaOpt.isEmpty()) return "redirect:/categorias";

        model.addAttribute("categoria", categoriaOpt.get());
        model.addAttribute("productos", productoService.findByCategoria(id, sortField, sortDir));
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);

        return "categorias/categoria";
    }
}