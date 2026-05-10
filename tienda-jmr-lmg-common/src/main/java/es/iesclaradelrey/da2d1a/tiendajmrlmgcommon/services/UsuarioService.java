package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Usuario;
import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findById(Long userId);
    Usuario save(Usuario usuario);
}