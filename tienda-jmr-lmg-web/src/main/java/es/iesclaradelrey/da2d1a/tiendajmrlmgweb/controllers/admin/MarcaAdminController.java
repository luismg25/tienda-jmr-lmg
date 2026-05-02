package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.controllers.admin;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.MarcaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/marcas")
public class MarcaAdminController {

    private final MarcaService marcaService;

    public MarcaAdminController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    // Redirige URL con barra final
    @GetMapping("/")
    public String redirectSlash() {
        return "redirect:/admin/marcas";
    }

    // Listado
    @GetMapping
    public String listado(Model model) {
        model.addAttribute("marcas", marcaService.findAll());
        return "admin/marcas/listado";
    }

    // Formulario crear
    @GetMapping("/new")
    public String formNuevo(Model model) {
        model.addAttribute("marca", new Marca());
        return "admin/marcas/formulario";
    }

    // Guardar nueva
    @PostMapping("/new")
    public String guardarNuevo(@ModelAttribute Marca marca, Model model) {
        try {
            marcaService.save(marca);
            return "redirect:/admin/marcas";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("marca", marca);
            return "admin/marcas/formulario";
        }
    }

    // Formulario editar
    @GetMapping("/{id}/edit")
    public String formEditar(@PathVariable Long id, Model model) {
        return marcaService.findById(id).map(marca -> {
            model.addAttribute("marca", marca);
            return "admin/marcas/formulario";
        }).orElse("redirect:/admin/marcas");
    }

    // Guardar edición
    @PostMapping("/{id}/edit")
    public String guardarEdicion(@PathVariable Long id, @ModelAttribute Marca marca, Model model) {
        try {
            marca.setId(id);
            marcaService.save(marca);
            return "redirect:/admin/marcas";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("marca", marca);
            return "admin/marcas/formulario";
        }
    }

    // Formulario borrar
    @GetMapping("/{id}/delete")
    public String formBorrar(@PathVariable Long id, Model model) {
        return marcaService.findById(id).map(marca -> {
            model.addAttribute("marca", marca);
            return "admin/marcas/borrar";
        }).orElse("redirect:/admin/marcas");
    }

    // Ejecutar borrado
    @PostMapping("/{id}/delete")
    public String ejecutarBorrado(@PathVariable Long id, Model model) {
        try {
            marcaService.deleteById(id);
            return "redirect:/admin/marcas";
        } catch (Exception e) {
            return marcaService.findById(id).map(marca -> {
                model.addAttribute("marca", marca);
                model.addAttribute("error", e.getMessage());
                return "admin/marcas/borrar";
            }).orElse("redirect:/admin/marcas");
        }
    }
}