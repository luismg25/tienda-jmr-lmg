package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    // genera un access token de corta duración
    String generateAccessToken(UserDetails user);

    // Genera un refresh token con mayor duración:
    String generateRefreshToken(UserDetails user);

    //Extrae el nombre de usuario del token
    String extractUsername(String token);

    // si el token ha caducado
    Boolean isTokenExpired(String token);

    // Valida que el token no ha caducado y pertenece al usuario dado
    Boolean isTokenValid(String token, UserDetails user);
}