package br.com.fiap.sos_tera.repository;

import br.com.fiap.sos_tera.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
