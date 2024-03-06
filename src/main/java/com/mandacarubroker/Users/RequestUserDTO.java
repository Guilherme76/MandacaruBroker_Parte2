package com.mandacarubroker.Users;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.checkerframework.common.aliasing.qual.Unique;

public record RequestUserDTO(
    @Unique
    @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}",
            message = "Endereço de e-mail inválido ou em branco")
    @NotBlank
    String email,
    @NotBlank
    @Pattern(regexp = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$",
            message = "Formato de data inválida")
    String birthDate,
    @Unique
    @NotBlank
    String username,
    @NotBlank
    String password,
    @NotBlank
    String firstName,
    @NotBlank
    String lastName,
    @NotBlank
    double balance
) {
}

