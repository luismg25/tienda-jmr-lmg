package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.controllers;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.MarcaService;
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

    private static final List<String> CAMPOS_ORDENACION = List.of(
            "id", "nombre", "origen", "precio", "marca.nombre", "agotado", "descuento"
    );

    private final ProductoService productoService;
    private final MarcaService marcaService;

    public CatalogoController(ProductoService productoService, MarcaService marcaService) {
        this.productoService = productoService;
        this.marcaService = marcaService;
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

        String safeSortField = CAMPOS_ORDENACION.contains(sortField) ? sortField : "nombre";

        model.addAttribute("productos", productoService.buscarConFiltros(nombre, marcaId, origen, minPrecio, maxPrecio, safeSortField, sortDir));
        model.addAttribute("marcas", marcaService.findAll());
        model.addAttribute("nombre", nombre);
        model.addAttribute("origen", origen);
        model.addAttribute("marcaId", marcaId);
        model.addAttribute("minPrecio", minPrecio);
        model.addAttribute("maxPrecio", maxPrecio);
        model.addAttribute("sortField", safeSortField);
        model.addAttribute("sortDir", sortDir);

        return "productos/listado";
    }
}
