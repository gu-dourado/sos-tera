package br.com.fiap.sos_tera.repository;

import br.com.fiap.sos_tera.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
