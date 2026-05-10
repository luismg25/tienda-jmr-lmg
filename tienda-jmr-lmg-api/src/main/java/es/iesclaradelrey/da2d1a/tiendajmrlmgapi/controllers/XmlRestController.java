package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.controllers;

import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.services.XmlApiService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/v1/xml")
public class XmlRestController {
    private final XmlApiService xmlApiService;

    public XmlRestController(XmlApiService xmlApiService) {
        this.xmlApiService = xmlApiService;
    }

    @GetMapping
    public ResponseEntity<byte[]> exportXml() throws Exception {
        Document doc = xmlApiService.exportProductsToXml();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(doc), new StreamResult(outputStream));

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd.HHmmss"));
        String filename = "products-export." + timestamp + ".xml";

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
            .contentType(MediaType.APPLICATION_XML)
            .body(outputStream.toByteArray());
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> importXml(@RequestParam("productsfile") MultipartFile file) throws Exception {
        xmlApiService.importProductsFromXml(file);
        return ResponseEntity.ok().build();
    }
}