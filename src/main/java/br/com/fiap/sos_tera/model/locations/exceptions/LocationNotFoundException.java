package br.com.fiap.sos_tera.model.locations.exceptions;

public class LocationNotFoundException extends RuntimeException {
  public LocationNotFoundException(String message) {
    super(message);
  }
}
