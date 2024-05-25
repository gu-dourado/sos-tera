package br.com.fiap.sos_tera.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegisterDTO(
        @NotBlank(message = "Name is required!")
        String name,

        @NotBlank(message = "Email is required!")
        @Email(message = "Invalid email!")
        String email,

        @NotBlank(message = "Password is required!")
        @Size(min = 6, max = 20, message = "The password must contain between 6 and 20 characters!")
        String password
) {
}
