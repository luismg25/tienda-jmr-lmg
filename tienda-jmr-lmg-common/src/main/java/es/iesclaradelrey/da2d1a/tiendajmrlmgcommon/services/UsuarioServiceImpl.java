package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.UsuarioRegistrado;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl( UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<UsuarioRegistrado>findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public UsuarioRegistrado save(UsuarioRegistrado usuario) {
        return usuarioRepository.save(usuario);
    }
}