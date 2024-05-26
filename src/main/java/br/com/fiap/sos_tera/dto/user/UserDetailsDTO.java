package br.com.fiap.sos_tera.dto.user;

import br.com.fiap.sos_tera.entity.user.User;

public record UserDetailsDTO(
        Long id,
        String nome,
        String email
) {
  public UserDetailsDTO(User user) {
    this(user.getId(), user.getNome(), user.getEmail());
  }
}
