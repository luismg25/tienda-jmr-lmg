package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.controllers.admin;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/categorias")
public class CategoriaAdminController {

    private final CategoriaService categoriaService;

    public CategoriaAdminController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/")
    public String redirectSlash() {
        return "redirect:/admin/categorias";
    }

    @GetMapping
    public String listado(Model model) {
        model.addAttribute("categorias", categoriaService.findAll());
        return "admin/categorias/listado";
    }

    @GetMapping("/new")
    public String formNuevo(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "admin/categorias/formulario";
    }

    @PostMapping("/new")
    public String guardarNuevo(@ModelAttribute Categoria categoria, Model model) {
        try {
            categoriaService.save(categoria);
            return "redirect:/admin/categorias";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("categoria", categoria);
            return "admin/categorias/formulario";
        }
    }

    @GetMapping("/{id}/edit")
    public String formEditar(@PathVariable Long id, Model model) {
        return categoriaService.findById(id).map(categoria -> {
            model.addAttribute("categoria", categoria);
            return "admin/categorias/formulario";
        }).orElse("redirect:/admin/categorias");
    }

    @PostMapping("/{id}/edit")
    public String guardarEdicion(@PathVariable Long id, @ModelAttribute Categoria categoria, Model model) {
        try {
            categoria.setId(id);
            categoriaService.save(categoria);
            return "redirect:/admin/categorias";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("categoria", categoria);
            return "admin/categorias/formulario";
        }
    }

    @GetMapping("/{id}/delete")
    public String formBorrar(@PathVariable Long id, Model model) {
        return categoriaService.findById(id).map(categoria -> {
            model.addAttribute("categoria", categoria);
            return "admin/categorias/borrar";
        }).orElse("redirect:/admin/categorias");
    }

    @PostMapping("/{id}/delete")
    public String ejecutarBorrado(@PathVariable Long id, Model model) {
        try {
            categoriaService.deleteById(id);
            return "redirect:/admin/categorias";
        } catch (Exception e) {
            return categoriaService.findById(id).map(cat -> {
                model.addAttribute("categoria", cat);
                model.addAttribute("error", e.getMessage());
                return "admin/categorias/borrar";
            }).orElse("redirect:/admin/categorias");
        }
    }
}