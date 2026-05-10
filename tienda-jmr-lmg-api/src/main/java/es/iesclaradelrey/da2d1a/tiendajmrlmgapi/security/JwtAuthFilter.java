package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public JwtAuthFilter(JwtService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        try {
            //1. Comprobar si el usuario ya está autenticado por un filtro previo
            if (SecurityContextHolder.getContext().getAuthentication() != null) {
                filterChain.doFilter(request, response);
                return;
            }

            // 2.Comprobar que existe la cabecera Authorization
            String authHeader = request.getHeader("Authorization");
            if (authHeader == null) {
                filterChain.doFilter(request, response);
                return;
            }

            //3.Verificar que la cabecera comienza con "Bearer " (con espacio)
            if (!authHeader.startsWith("Bearer ")) {
                filterChain.doFilter(request, response);
                return;
            }

            // 4. Extraer el token de la cabecera
            String token = authHeader.substring(7);

            // 5. Extraer el nombre de usuario — lanza excepción si el token fue manipulado
            String username = jwtService.extractUsername(token);

            // 6. Buscar el usuario -- lanza UsernameNotFoundException si no existe
            UserDetails user = userDetailsService.loadUserByUsername(username);

            // 7.Verificar que el token es válido para ese usuario
            if (!jwtService.isTokenValid(token, user)) {
                filterChain.doFilter(request, response);
                return;
            }

            //8.Crear objeto Authentication y fijarlo en el SecurityContext
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (Exception e) {
            // Cualquier excepción (token manipulado, usuario no encontrado, etc.)
            //simplemente pasamos al siguiente filtro sin autenticar
        }

        //Siempre pasamos el testigo al siguiente filtro de la cadena
        filterChain.doFilter(request, response);
    }
}