package com.mandacarubroker.Users;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record RequestUserDTO(
    @NotBlank()
    String companyName,
    String username,
    String password,
    String email,
    String firstName,
    String lastName,
    Date birthDate,
    double balance
){}

