package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Usuario;
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
    public Optional<Usuario>findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}