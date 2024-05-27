package br.com.fiap.sos_tera.dto.alert;

import br.com.fiap.sos_tera.model.alert.Alert;

public record AlertDetailsDTO(
        Long id,
        String tipoDesastre,
        String dataHora,
        String gravidade,
        String status,
        String localizacao
) {
  public AlertDetailsDTO(Alert alert) {
    this(alert.getId(), alert.getTipoDesastre(), alert.getDataHora(), alert.getGravidade(), alert.getStatus(), alert.getLocalizacao());
  }
}
