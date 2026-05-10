package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.sax;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories.CategoriaRepository;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories.MarcaRepository;
import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.exceptions.ProductoNotFoundException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductoSAXHandler extends DefaultHandler {

    private final MarcaRepository marcaRepository;
    private final CategoriaRepository categoriaRepository;

    private List<Producto> productos = new ArrayList<>();
    private Producto productoActual;
    private StringBuilder valorActual = new StringBuilder();

    public ProductoSAXHandler(MarcaRepository marcaRepository, CategoriaRepository categoriaRepository) {
        this.marcaRepository = marcaRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        valorActual.setLength(0);
        if (qName.equalsIgnoreCase("producto")) {
            productoActual = new Producto();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        valorActual.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (productoActual == null) return;

        String texto = valorActual.toString().trim();

        switch (qName.toLowerCase()) {
            case "nombre" -> productoActual.setNombre(texto);
            case "precio" -> productoActual.setPrecio(new BigDecimal(texto));
            case "stock" -> productoActual.setStock(Integer.parseInt(texto));
            case "marca" -> {
                Marca marca = marcaRepository.findByNombre(texto).orElseThrow(() -> new RuntimeException("MARCA_NOT_FOUND:" + texto));
                productoActual.setMarca(marca);
            }
            case "categoria" -> {
                Categoria cat = categoriaRepository.findByNombre(texto).orElseThrow(() -> new RuntimeException("CATEGORIA_NOT_FOUND:" + texto));
                productoActual.getCategorias().add(cat);
            }
            case "producto" -> {
                productos.add(productoActual);
                productoActual = null;
            }
        }
    }
}