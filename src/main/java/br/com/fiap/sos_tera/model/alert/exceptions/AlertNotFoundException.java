package br.com.fiap.sos_tera.model.alert.exceptions;

public class AlertNotFoundException extends RuntimeException {
  public AlertNotFoundException(String message) {
    super(message);
  }
}
