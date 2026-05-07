package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.UsuarioRegistrado;
import java.util.Optional;

public interface UsuarioService {
    Optional<UsuarioRegistrado> findByEmail(String email);
    UsuarioRegistrado save(UsuarioRegistrado usuario);
}