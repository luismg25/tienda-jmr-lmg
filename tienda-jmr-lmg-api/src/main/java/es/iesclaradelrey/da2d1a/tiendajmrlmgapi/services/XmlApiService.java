package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.services;

import org.w3c.dom.Document;

public interface XmlApiService {
    Document exportProductsToXml() throws Exception;
    void importProductsFromXml(org.springframework.web.multipart.MultipartFile file) throws Exception;
}