package br.com.fiap.sos_tera.repository;

import br.com.fiap.sos_tera.entity.alert.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert, Long> {
}
