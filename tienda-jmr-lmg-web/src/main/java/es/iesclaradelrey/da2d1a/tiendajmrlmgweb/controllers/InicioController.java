package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.controllers;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class InicioController {

    private final ProductoService productoService;

    public InicioController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Producto> ofertas = productoService
                .buscarConFiltros(null, null, null, null, null, "descuento", "desc")
                .stream()
                .filter(p -> p.getDescuento() != null && p.getDescuento() > 0)
                .limit(8)
                .toList();

        model.addAttribute("gruposOfertas", agrupar(ofertas, 4));
        return "index";
    }

    private <T> List<List<T>> agrupar(List<T> lista, int tamano) {
        List<List<T>> grupos = new ArrayList<>();
        for (int i = 0; i < lista.size(); i += tamano) {
            grupos.add(lista.subList(i, Math.min(i + tamano, lista.size())));
        }
        return grupos;
    }
}