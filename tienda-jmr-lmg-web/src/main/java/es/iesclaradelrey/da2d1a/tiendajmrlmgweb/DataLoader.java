package es.iesclaradelrey.da2d1a.tiendajmrlmgweb;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.CategoriaService;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.ProductoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

//Clase para cargar datos con repositorio genérico y CommandLineRunner
@Component
public class DataLoader implements CommandLineRunner {

    private final CategoriaService categoriaService;
    private final ProductoService productoService;

    public DataLoader(CategoriaService cs, ProductoService ps) {
        this.categoriaService = cs;
        this.productoService = ps;
    }

    @Override
    public void run(String... args) throws Exception {
        // --- CATEGORÍAS ---
        categoriaService.save(new Categoria(1L, "Gemas Preciosas", "Piedras de alta pureza y valor gemológico.", "gemas.jpg"));
        categoriaService.save(new Categoria(2L, "Piedras Ornamentales", "Piedras estéticas de gama media para decoración.", "ornamentales.jpg"));
        categoriaService.save(new Categoria(3L, "Piedras Comunes", "Rocas y piedras abundantes de uso general.", "comunes.jpg"));
        categoriaService.save(new Categoria(4L, "Minerales", "Especímenes cristalinos y menas metálicas.", "minerales.jpg"));
        categoriaService.save(new Categoria(5L, "Fósiles", "Restos orgánicos mineralizados de eras geológicas.", "fosiles.jpg"));

        // --- PRODUCTOS CATEGORÍA 1: GEMAS PRECIOSAS ---
        productoService.save(new Producto(1L, "Diamante Azul", 1L, new BigDecimal("12000"), false, null, LocalDate.of(2024, 1, 10), null, 1.1, 1.1, 0.9, "Rareza extrema.", "https://www.naturaldiamonds.com/wp-content/uploads/2025/03/HIS_AUC_Francois-Curiel-profile_7634-lot-212-The-Wittelsbach-Blue_IMG_4x5.jpg"));
        productoService.save(new Producto(2L, "Rubí Sangre", 1L, new BigDecimal("4500"), false, null, LocalDate.of(2024, 2, 5), 1.2, 0.8, 0.8, 0.6, "Color rojo intenso.", "https://imgcdn1.gempundit.com/media/catalog/product/g/p1/gp55623-1-130521.jpg?imgeng=/w_960/f_webp/cmpr_20/s_7"));
        productoService.save(new Producto(3L, "Esmeralda", 1L, new BigDecimal("3800"), true, "Colombia", LocalDate.of(2024, 2, 15), 2.1, 1.5, 1.4, 1.0, "Verde Muzo.", "https://jrcolombianemeralds.com/cdn/shop/files/jr-colombian-emeralds-default-title-3-86-carat-deep-emerald-green-natural-loose-colombian-emerald-oval-cut-23042052980830.jpg?v=1776806235&width=1920"));
        productoService.save(new Producto(4L, "Zafiro Real", 1L, new BigDecimal("5100"), false, "Sri Lanka", LocalDate.of(2024, 3, 1), 1.7, 1.0, 1.0, 0.9, "Azul real.", "https://www.claudiahamann.com/hmn/uploads/2019/06/ClaudiaHamann_Sapphire_Ceylon_Octagon_RoyalBlue_452cts_.jpg"));
        productoService.save(new Producto(5L, "Alejandrita", 1L, new BigDecimal("7200"), false, null, LocalDate.of(2024, 3, 20), null, 0.6, 0.6, 0.5, "Cambio de color.", "https://omiprive.com/wp-content/uploads/2023/08/Alexandrite_new.jpg"));
        productoService.save(new Producto(6L, "Espinela Roja", 1L, new BigDecimal("1800"), false, "Tanzania", LocalDate.of(2024, 4, 1), 3.0, 1.2, 1.2, 1.0, "Gran brillo.", "https://marcelvermeulen.com/cdn/shop/articles/spinel_blog.jpg?v=1603818947"));

        // --- PRODUCTOS CATEGORÍA 2: PIEDRAS ORNAMENTALES ---
        productoService.save(new Producto(7L, "Lapislázuli Extra", 2L, new BigDecimal("150"), false, "Afganistán", LocalDate.of(2024, 1, 15), null, 10.0, 8.0, 5.0, "Azul intenso.", null));
        productoService.save(new Producto(8L, "Malaquita Pulida", 2L, new BigDecimal("85"), false, null, LocalDate.of(2024, 2, 10), null, 7.0, 6.0, 4.0, "Bandas verdes.", null));
        productoService.save(new Producto(9L, "Rodocrosita", 2L, new BigDecimal("120"), false, "Argentina", LocalDate.of(2024, 2, 28), 200.0, 5.0, 5.0, 4.0, "Rosa bandas.", null));
        productoService.save(new Producto(10L, "Jade Nefrita", 2L, new BigDecimal("210"), false, null, LocalDate.of(2024, 3, 15), 450.0, 12.0, 6.0, 2.0, "Símbolo suerte.", null));
        productoService.save(new Producto(11L, "Turquesa Natural", 2L, new BigDecimal("95"), true, null, LocalDate.of(2024, 4, 5), null, 4.0, 3.0, 2.0, "Azul cielo.", null));
        productoService.save(new Producto(12L, "Amatista Geoda", 2L, new BigDecimal("180"), false, "Uruguay", LocalDate.of(2024, 4, 12), 1200.0, 15.0, 12.0, 10.0, "Cristal violeta.", null));

        // --- PRODUCTOS CATEGORÍA 3: PIEDRAS COMUNES ---
        productoService.save(new Producto(13L, "Obsidiana Negra", 3L, new BigDecimal("25"), false, "México", LocalDate.of(2024, 1, 20), null, 10.0, 10.0, 8.0, "Vidrio volcánico.", null));
        productoService.save(new Producto(14L, "Cuarzo Rosa", 3L, new BigDecimal("15"), false, "Brasil", LocalDate.of(2024, 2, 12), 600.0, 12.0, 8.0, 8.0, "Piedra bruta.", null));
        productoService.save(new Producto(15L, "Ágata Cornalina", 3L, new BigDecimal("12"), false, null, LocalDate.of(2024, 3, 5), null, 5.0, 4.0, 3.0, "Canto rodado.", null));
        productoService.save(new Producto(16L, "Sodalita", 3L, new BigDecimal("20"), false, null, LocalDate.of(2024, 3, 18), 300.0, 8.0, 6.0, 5.0, "Azul veteado.", null));
        productoService.save(new Producto(17L, "Jaspe Rojo", 3L, new BigDecimal("10"), false, null, LocalDate.of(2024, 4, 2), null, 7.0, 5.0, 5.0, "Piedra opaca.", null));
        productoService.save(new Producto(18L, "Calcita Óptica", 3L, new BigDecimal("35"), false, "Islandia", LocalDate.of(2024, 4, 10), 150.0, 5.0, 5.0, 4.0, "Doble refracción.", null));

        // --- PRODUCTOS CATEGORÍA 4: MINERALES ---
        productoService.save(new Producto(19L, "Pirita Cúbica", 4L, new BigDecimal("45"), false, "España", LocalDate.of(2024, 1, 30), null, 6.0, 6.0, 6.0, "Cubos perfectos.", null));
        productoService.save(new Producto(20L, "Bismuto Cristal", 4L, new BigDecimal("55"), false, null, LocalDate.of(2024, 2, 15), null, 7.0, 5.0, 5.0, "Iridiscente.", null));
        productoService.save(new Producto(21L, "Galena", 4L, new BigDecimal("30"), false, null, LocalDate.of(2024, 3, 5), 500.0, 6.0, 5.0, 5.0, "Mena pesada.", null));
        productoService.save(new Producto(22L, "Fluorita Octaédrica", 4L, new BigDecimal("65"), true, null, LocalDate.of(2024, 3, 22), null, 5.0, 5.0, 5.0, "Colores flúor.", null));
        productoService.save(new Producto(23L, "Magnetita", 4L, new BigDecimal("25"), false, "Suecia", LocalDate.of(2024, 4, 5), null, 8.0, 7.0, 6.0, "Imán natural.", null));
        productoService.save(new Producto(24L, "Antimonita", 4L, new BigDecimal("110"), false, "Japón", LocalDate.of(2024, 4, 15), 350.0, 15.0, 3.0, 3.0, "Agujas largas.", null));

        // --- PRODUCTOS CATEGORÍA 5: FÓSILES ---
        productoService.save(new Producto(25L, "Ammonite Cleoniceras", 5L, new BigDecimal("120"), false, null, LocalDate.of(2024, 1, 20), null, 14.0, 12.0, 3.0, "Corte pulido.", null));
        productoService.save(new Producto(26L, "Trilobite Calymene", 5L, new BigDecimal("85"), false, null, LocalDate.of(2024, 2, 12), 300.0, 9.0, 6.0, 4.0, "Paleozoico.", null));
        productoService.save(new Producto(27L, "Diente de Megalodón", 5L, new BigDecimal("450"), false, null, LocalDate.of(2024, 2, 25), null, 12.0, 15.0, 4.0, "Esmalte natural.", null));
        productoService.save(new Producto(28L, "Madera Petrificada", 5L, new BigDecimal("70"), false, "Indonesia", LocalDate.of(2024, 3, 10), null, 20.0, 15.0, 5.0, "Tronco ágata.", null));
        productoService.save(new Producto(29L, "Libélula en Ámbar", 5L, new BigDecimal("950"), true, null, LocalDate.of(2024, 3, 28), 15.0, 3.0, 2.0, 1.5, "Inclusión única.", null));
        productoService.save(new Producto(30L, "Diente de Espinosaurio", 5L, new BigDecimal("140"), false, "Marruecos", LocalDate.of(2024, 4, 10), 80.0, 2.5, 8.0, 2.5, "Cretácico.", null));

    }
}
