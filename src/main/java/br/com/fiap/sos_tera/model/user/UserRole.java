package br.com.fiap.sos_tera.model.user;

import lombok.Getter;

@Getter
public enum UserRole {
  ADMIN("admin"),
  USER("user");

  private final String role;

  UserRole(String role) {
    this.role = role;
  }
}
