package br.com.fiap.sos_tera.dto.alert;

import br.com.fiap.sos_tera.entity.alert.Alert;

public record AlertDetailsDTO(
        Long id,
        String tipoDesastre,
        String dataHora,
        String gravidade,
        String status
) {
  public AlertDetailsDTO(Alert alert) {
    this(alert.getId(), alert.getTipoDesastre(), alert.getDataHora(), alert.getGravidade(), alert.getStatus());
  }
}
