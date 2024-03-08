package com.mandacarubroker.helpers;

import com.mandacarubroker.utils.UserRole;

public record RegisterDTO(
        String login,
        String password,
        String email,
        String firstName,
        String lastName,
        String birthDate,
        double balance,
        UserRole role
){

}
