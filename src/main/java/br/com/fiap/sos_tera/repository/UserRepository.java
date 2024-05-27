package br.com.fiap.sos_tera.repository;

import br.com.fiap.sos_tera.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
  UserDetails findByEmail(String email);
}
