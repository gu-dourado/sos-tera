package br.com.fiap.sos_tera.dto;

import br.com.fiap.sos_tera.entity.User;

public record UserDetailsDTO(
        Long id,
        String name,
        String email
) {
  public UserDetailsDTO(User user) {
    this(user.getId(), user.getNome(), user.getEmail());
  }
}
