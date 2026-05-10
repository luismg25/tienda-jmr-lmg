package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.sax.ProductoSAXHandler;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories.CategoriaRepository;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories.MarcaRepository;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

// Genera el árbol XML recorriendo todos los productos
@Service
public class XmlApiServiceImpl implements XmlApiService {
    private final ProductoRepository productoRepository;
    private final MarcaRepository marcaRepository;
    private final CategoriaRepository categoriaRepository;

    public XmlApiServiceImpl(ProductoRepository productoRepository,
     MarcaRepository marcaRepository,
     CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.marcaRepository = marcaRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Document exportProductsToXml() throws Exception {
        List<Producto> productos = productoRepository.findAll();

        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element rootElement = doc.createElement("productos");
        doc.appendChild(rootElement);

        for (Producto p : productos) {
            Element prodElem = doc.createElement("producto");
            prodElem.setAttribute("id", p.getId().toString());

            addNode(doc, prodElem, "nombre", p.getNombre());
            addNode(doc, prodElem, "precio", p.getPrecio().toString());
            addNode(doc, prodElem, "stock", p.getStock().toString());
            addNode(doc, prodElem, "marca", p.getMarca().getNombre());

            Element catsElem = doc.createElement("categorias");
            p.getCategorias().forEach(c -> addNode(doc, catsElem, "categoria", c.getNombre()));
            prodElem.appendChild(catsElem);

            rootElement.appendChild(prodElem);
        }
        return doc;
    }

    @Override
    @Transactional
    public void importProductsFromXml(MultipartFile file) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        ProductoSAXHandler handler = new ProductoSAXHandler(marcaRepository, categoriaRepository);
        // Lanza RuntimeException si una marca o categoría no existe, si falla un producto no se guarda ninguno
        saxParser.parse(file.getInputStream(), handler);

        List<Producto> productos = handler.getProductos();
        productoRepository.saveAll(productos);
    }

    private void addNode(Document doc, Element parent, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value != null ? value : ""));
        parent.appendChild(node);
    }
}