package br.com.fiap.sos_tera.dto.alert;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AlertRegisterDTO(
        Long id,

        @NotBlank(message = "Tipo do desastre é obrigatório!")
        String tipoDesastre,

        @NotBlank(message = "Gravidade é obrigatório!")
        @Size(max = 1, message = "Gravidade deve conter apenas 1 caractere!")
        String gravidade,

        @NotBlank(message = "Status é obrigatório!")
        String status
) {

}
