package com.mandacarubroker.Users;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.checkerframework.common.aliasing.qual.Unique;

public record RequestUserDTO(
    @Unique
    @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}",
            message = "Endereço de e-mail inválido ou em branco")
    @NotNull
    String email,
    @NotNull
    @Pattern(regexp = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$",
            message = "Formato de data inválida")
    String birthDate,
    @Unique
    @NotNull
    String username,
    @NotNull
    String password,
    String firstName,
    String lastName,
    @NotNull
    double balance
) {
}

