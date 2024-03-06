package com.mandacarubroker.Users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

public record RequestUserDTO(
        @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
                message = "Formato de e-mail inválido")
        @NotBlank(message = "O e-mail não pode estar em branco")
        String email,

        @NotNull(message = "A data de nascimento não pode estar em branco")
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        Date birthDate,

        @Pattern(regexp = "^[0-9]{6}$",
                message = "A senha deve conter exatamente 6 números")
        @NotBlank(message = "A senha não pode estar em branco")
        String password,

        @Pattern(regexp = "^[a-zA-Z]+$",
                message = "O nome de usuário deve conter apenas letras")
        @NotBlank(message = "O nome de usuário não pode estar vazio")
        String username,

        @Pattern(regexp = "^[a-zA-Z]+$",
                message = "O primeiro nome deve conter apenas letras")
        @NotBlank(message = "O primeiro nome não pode estar em branco")
        String firstName,

        @Pattern(regexp = "^[a-zA-Z]+$",
                message = "O sobrenome deve conter apenas letras")
        @NotBlank(message = "O sobrenome não pode estar em branco")
        String lastName,

        @NotNull(message = "O saldo não pode estar em branco")
        double balance
) {}
