package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.controllers;

import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.dto.*;
import es.iesclaradelrey.da2d1a.tiendajmrlmgapi.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtService jwtService,
                          UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

     // POST /api/v1/auth/login
     //Recibe email + password, valida credenciales y devuelve access + refresh token.
    //responde 401 si las credenciales son incorrectas.

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
        try {
            // Valida las credenciales usando el AuthenticationManager
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        UserDetails user = userDetailsService.loadUserByUsername(request.getEmail());
        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return ResponseEntity.ok(new LoginResponseDTO(accessToken, refreshToken));
    }

     //POST /api/v1/auth/refresh
     //Recibe un refresh token y devuelve un nuevo access token.
     // Responde 400 si el refresh token no es válido.
     //
    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody RefreshRequestDTO request) {
        try {
            String username = jwtService.extractUsername(request.getRefreshToken());
            UserDetails user = userDetailsService.loadUserByUsername(username);

            if (!jwtService.isTokenValid(request.getRefreshToken(), user)) {
                return ResponseEntity.badRequest().build();
            }

            String newAccessToken = jwtService.generateAccessToken(user);
            return ResponseEntity.ok(new RefreshResponseDTO(newAccessToken));

        } catch (Exception e) {
            //token manipulado, caducado o usuario no encontrado
            return ResponseEntity.badRequest().build();
        }
    }
}
