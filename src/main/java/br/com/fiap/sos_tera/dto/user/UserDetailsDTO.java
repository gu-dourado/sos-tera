package br.com.fiap.sos_tera.dto.user;

import br.com.fiap.sos_tera.model.user.User;
import br.com.fiap.sos_tera.model.user.UserRole;

public record UserDetailsDTO(
        Long id,
        String nome,
        String email,
        UserRole role
) {
  public UserDetailsDTO(User user) {
    this(user.getId(), user.getNome(), user.getEmail(), user.getRole());
  }
}
