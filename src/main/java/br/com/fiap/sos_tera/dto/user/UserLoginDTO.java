package br.com.fiap.sos_tera.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserLoginDTO(
        @NotBlank(message = "Email é obrigatório!")
        @Email(message = "Email invalido!")
        String email,

        @NotBlank(message = "Senha é obrigatório!")
        @Size(min = 6, max = 20, message = "A senha deve conter no minimo 6 e no maximo 20 caracteres!")
        String senha
) {
}