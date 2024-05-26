package br.com.fiap.sos_tera.dto.location;

import br.com.fiap.sos_tera.entity.locations.Location;

public record LocationDetailsDTO(
        Long id,
        String latitude,
        String longitude,
        String nome
) {
  public LocationDetailsDTO(Location location) {
    this(location.getId(), location.getLatitude(), location.getLongitude(), location.getNome());
  }
}
