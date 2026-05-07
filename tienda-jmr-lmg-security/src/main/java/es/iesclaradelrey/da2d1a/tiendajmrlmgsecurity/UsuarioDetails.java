package es.iesclaradelrey.da2d1a.tiendajmrlmgsecurity;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.UsuarioRegistrado;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UsuarioDetails implements UserDetails {

    private final UsuarioRegistrado usuario;

    public UsuarioDetails(UsuarioRegistrado usuario) {
        this.usuario = usuario;
    }

    @Override
    public String getUsername() {
        return usuario.getEmail();  // email como username
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    // Estos métodos devuelven true para que la cuenta esté activa
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }

    // Getter para acceder al usuario desde thymeleaf
    public UsuarioRegistrado getUsuario() {
        return usuario;
    }
}