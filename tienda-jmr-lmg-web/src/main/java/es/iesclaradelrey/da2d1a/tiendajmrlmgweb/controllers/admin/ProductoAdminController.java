package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.controllers.admin;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.CategoriaService;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.MarcaService;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/productos")
public class ProductoAdminController {

    private final ProductoService productoService;
    private final MarcaService marcaService;
    private final CategoriaService categoriaService;

    public ProductoAdminController(ProductoService productoService,
                                   MarcaService marcaService,
                                   CategoriaService categoriaService) {
        this.productoService = productoService;
        this.marcaService = marcaService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/")
    public String redirectSlash() {
        return "redirect:/admin/productos";
    }

    @GetMapping
    public String listado(Model model) {
        model.addAttribute("productos", productoService.buscarConFiltros(
                null, null, null, null, null, "nombre", "asc"));
        return "admin/productos/listado";
    }

    private void cargarDatosFormulario(Model model) {
        model.addAttribute("marcas", marcaService.findAll());
        model.addAttribute("categorias", categoriaService.findAll());
    }

    @GetMapping("/new")
    public String formNuevo(Model model) {
        model.addAttribute("producto", new Producto());
        cargarDatosFormulario(model);
        return "admin/productos/formulario";
    }

    @PostMapping("/new")
    public String guardarNuevo(@ModelAttribute Producto producto,
                               @RequestParam(required = false) Long marcaId,
                               @RequestParam(required = false) List<Long> categoriaIds,
                               Model model) {
        try {
            asignarRelaciones(producto, marcaId, categoriaIds);
            productoService.save(producto);
            return "redirect:/admin/productos";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("producto", producto);
            cargarDatosFormulario(model);
            return "admin/productos/formulario";
        }
    }

    @GetMapping("/{id}/edit")
    public String formEditar(@PathVariable Long id, Model model) {
        return productoService.findById(id).map(producto -> {
            model.addAttribute("producto", producto);
            cargarDatosFormulario(model);
            return "admin/productos/formulario";
        }).orElse("redirect:/admin/productos");
    }

    @PostMapping("/{id}/edit")
    public String guardarEdicion(@PathVariable Long id,
                                 @ModelAttribute Producto producto,
                                 @RequestParam(required = false) Long marcaId,
                                 @RequestParam(required = false) List<Long> categoriaIds,
                                 Model model) {
        try {
            producto.setId(id);
            asignarRelaciones(producto, marcaId, categoriaIds);
            productoService.save(producto);
            return "redirect:/admin/productos";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("producto", producto);
            cargarDatosFormulario(model);
            return "admin/productos/formulario";
        }
    }

    @GetMapping("/{id}/delete")
    public String formBorrar(@PathVariable Long id, Model model) {
        return productoService.findById(id).map(producto -> {
            model.addAttribute("producto", producto);
            return "admin/productos/borrar";
        }).orElse("redirect:/admin/productos");
    }

    @PostMapping("/{id}/delete")
    public String ejecutarBorrado(@PathVariable Long id, Model model) {
        try {
            productoService.deleteById(id);
            return "redirect:/admin/productos";
        } catch (Exception e) {
            return productoService.findById(id).map(p -> {
                model.addAttribute("producto", p);
                model.addAttribute("error", e.getMessage());
                return "admin/productos/borrar";
            }).orElse("redirect:/admin/productos");
        }
    }

    private void asignarRelaciones(Producto producto, Long marcaId, List<Long> categoriaIds) {
        if (marcaId != null) {
            Marca marca = marcaService.findById(marcaId)
                    .orElseThrow(() -> new IllegalArgumentException("Marca no encontrada"));
            producto.setMarca(marca);
        }
        if (categoriaIds != null && !categoriaIds.isEmpty()) {
            List<Categoria> categorias = categoriaIds.stream()
                    .map(cid -> categoriaService.findById(cid)
                            .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada: " + cid)))
                    .toList();
            producto.setCategorias(categorias);
        } else {
            producto.setCategorias(new java.util.ArrayList<>());
        }
    }
}