package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.TipoEventoSeguridad;

public interface EventoSeguridadService {
    void registrar(String nombreUsuario, TipoEventoSeguridad tipo);
}