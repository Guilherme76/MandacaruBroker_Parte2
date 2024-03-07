package com.mandacarubroker.controller;

import com.mandacarubroker.domain.User;
import com.mandacarubroker.domain.UserRepository;
import com.mandacarubroker.helpers.LoginResponseDTO;
import com.mandacarubroker.helpers.RegisterDTO;
import com.mandacarubroker.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository repositoryUserLogin;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/login")
        public ResponseEntity login(@RequestBody @Valid RegisterDTO data){
        var usernamePass = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePass);
        var token = tokenService.generationToken((User)auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repositoryUserLogin.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword =  new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());

        this.repositoryUserLogin.save(newUser);

        return ResponseEntity.ok().build();
    }
}
