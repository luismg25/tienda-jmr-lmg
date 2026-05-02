package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.controllers;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {

    private final ProductoService productoService;

    public CatalogoController(ProductoService ps) {
        this.productoService = ps;
    }

    @GetMapping
    public String listado(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String origen,
            @RequestParam(required = false) Long marcaId,
            @RequestParam(required = false) Double minPrecio,
            @RequestParam(required = false) Double maxPrecio,
            @RequestParam(defaultValue = "nombre") String sortField,
            @RequestParam(defaultValue = "asc") String sortDir,
            Model model) {

        List<String> camposPermitidos = List.of("id", "nombre", "origen", "precio", "marca.nombre", "agotado", "descuento");
        String safeSortField = camposPermitidos.contains(sortField) ? sortField : "nombre";
        List<Producto> productos = productoService.buscarConFiltros(nombre, origen, minPrecio, maxPrecio, safeSortField, sortDir);
        if (marcaId != null) productos = productos.stream().filter(p -> p.getMarca().getId().equals(marcaId)).toList();
        var marcasUnicas = productos.stream().map(Producto::getMarca).distinct().toList();

        model.addAttribute("productos", productos);
        model.addAttribute("nombre", nombre);
        model.addAttribute("origen", origen);
        model.addAttribute("minPrecio", minPrecio);
        model.addAttribute("maxPrecio", maxPrecio);
        model.addAttribute("sortField", safeSortField);
        model.addAttribute("sortDir", sortDir);

        return "productos/listado";
    }
}
