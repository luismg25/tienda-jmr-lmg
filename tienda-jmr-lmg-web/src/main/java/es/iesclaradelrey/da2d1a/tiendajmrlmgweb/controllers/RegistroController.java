package es.iesclaradelrey.da2d1a.tiendajmrlmgweb.controllers;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.UsuarioRegistrado;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.UsuarioService;
import es.iesclaradelrey.da2d1a.tiendajmrlmgweb.dto.RegistroDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/register")
public class RegistroController {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    public RegistroController(UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String formulario(Model model) {
        model.addAttribute("registroDTO", new RegistroDTO());
        return "registro/formulario";
    }

    @PostMapping
    public String procesar(@ModelAttribute RegistroDTO registroDTO, Model model) {
        // Validar que aceptó las condiciones
        if (!registroDTO.isAceptaCondiciones()) {
            model.addAttribute("error", "Debes aceptar las condiciones para registrarte.");
            model.addAttribute("registroDTO", registroDTO);
            return "registro/formulario";
        }

        try {
            UsuarioRegistrado nuevo = new UsuarioRegistrado();
            nuevo.setNombre(registroDTO.getNombre());
            nuevo.setApellidos(registroDTO.getApellidos());
            nuevo.setEmail(registroDTO.getEmail());
            nuevo.setTelefono(registroDTO.getTelefono());
            nuevo.setFechaNacimiento(registroDTO.getFechaNacimiento());
            // La contraseña se guarda codificada con bcrypt
            nuevo.setPassword(passwordEncoder.encode(registroDTO.getPassword()));
            nuevo.setFechaRegistro(LocalDateTime.now());  // ← el servidor asigna esto

            usuarioService.save(nuevo);
            return "redirect:/login?registrado";

        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar el usuario: " + e.getMessage());
            model.addAttribute("registroDTO", registroDTO);
            return "registro/formulario";
        }
    }
}