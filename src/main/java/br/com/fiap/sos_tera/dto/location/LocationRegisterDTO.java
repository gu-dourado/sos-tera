package br.com.fiap.sos_tera.dto.location;

import jakarta.validation.constraints.NotBlank;

public record LocationRegisterDTO(
        Long id,

        @NotBlank(message = "Longitude é obrigatório!")
        String longitude,

        @NotBlank(message = "Latitude é obrigatório!")
        String latitude,

        @NotBlank(message = "Nome é obrigatório!")
        String nome
) {
}
