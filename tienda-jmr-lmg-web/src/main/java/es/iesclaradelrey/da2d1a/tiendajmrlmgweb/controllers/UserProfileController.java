package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.controllers;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.Usuario;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.UsuarioService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users/profile")
public class UserProfileController {

    private final UsuarioService usuarioService;

    public UserProfileController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Perfil del usuario conectado
    @GetMapping
    public String showMyProfile(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Usuario usuario = usuarioService.findByEmail(userDetails.getUsername())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        model.addAttribute("usuario", usuario);
        model.addAttribute("title", "Mi Perfil");
        return "users/profile";
    }

    // Perfil por ID (Solo ADMIN o el propio usuario)
    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN') or #userId == authentication.principal.id")
    public String showProfileById(@PathVariable Long userId, Model model) {
        Usuario usuario = usuarioService.findById(userId)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + userId));
        model.addAttribute("usuario", usuario);
        model.addAttribute("title", "Perfil de " + usuario.getNombre());
        return "users/profile";
    }
}