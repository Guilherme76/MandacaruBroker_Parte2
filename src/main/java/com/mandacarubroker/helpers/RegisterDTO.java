package com.mandacarubroker.helpers;

import com.mandacarubroker.utils.UserRole;

public record RegisterDTO(String login, String password, UserRole role){

}
