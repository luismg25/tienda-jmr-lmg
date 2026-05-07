package es.iesclaradelrey.da2d1a.tiendajmrlmgsecurity;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.TipoEventoSeguridad;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services.EventoSeguridadService;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEventListener {

    private final EventoSeguridadService eventoSeguridadService;

    public AuthenticationEventListener(EventoSeguridadService eventoSeguridadService) {
        this.eventoSeguridadService = eventoSeguridadService;
    }

    @EventListener
    public void onLoginExitoso(AuthenticationSuccessEvent event) {
        String email = event.getAuthentication().getName();
        eventoSeguridadService.registrar(email, TipoEventoSeguridad.LOGIN_EXITOSO);
    }

    @EventListener
    public void onLoginFallido(AbstractAuthenticationFailureEvent event) {
        String email = event.getAuthentication().getName();
        eventoSeguridadService.registrar(email, TipoEventoSeguridad.LOGIN_FALLIDO);
    }
}