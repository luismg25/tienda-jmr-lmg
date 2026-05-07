package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.services;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.EventoSeguridad;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.TipoEventoSeguridad;
import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories.EventoSeguridadRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class EventoSeguridadServiceImpl implements EventoSeguridadService {

    private final EventoSeguridadRepository repo;

    public EventoSeguridadServiceImpl(EventoSeguridadRepository repo) {
        this.repo = repo;
    }

    @Override
    public void registrar(String nombreUsuario, TipoEventoSeguridad tipo) {
        EventoSeguridad evento = new EventoSeguridad();
        evento.setFechaHora(LocalDateTime.now());
        evento.setNombreUsuario(nombreUsuario);
        evento.setTipo(tipo);
        repo.save(evento);
    }
}