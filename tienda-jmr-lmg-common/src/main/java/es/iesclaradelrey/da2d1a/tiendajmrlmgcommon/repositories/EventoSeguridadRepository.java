package es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.repositories;

import es.iesclaradelrey.da2d1a.tiendajmrlmgcommon.entities.EventoSeguridad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoSeguridadRepository extends JpaRepository<EventoSeguridad, Long> {
}