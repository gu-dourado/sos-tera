package br.com.fiap.sos_tera.model.user.exceptions;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String message) {
    super(message);
  }
}