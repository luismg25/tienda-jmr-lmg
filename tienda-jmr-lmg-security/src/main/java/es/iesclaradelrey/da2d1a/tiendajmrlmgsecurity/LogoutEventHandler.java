package es.iesclaradelrey.da2d1a.tiendajmrlmgsecurity;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.TipoEventoSeguridad;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.EventoSeguridadService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class LogoutEventHandler implements LogoutSuccessHandler {

    private final EventoSeguridadService eventoSeguridadService;

    public LogoutEventHandler(EventoSeguridadService eventoSeguridadService) {
        this.eventoSeguridadService = eventoSeguridadService;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                Authentication authentication) throws IOException {
        if (authentication != null) {
            eventoSeguridadService.registrar(authentication.getName(), TipoEventoSeguridad.LOGOUT);
        }
        response.sendRedirect("/");  // redirige a la página inicial
    }
}