package br.com.fiap.sos_tera.entity.alert.exceptions;

public class AlertNotFoundException extends RuntimeException {
  public AlertNotFoundException(String message) {
    super(message);
  }
}
