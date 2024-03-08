package com.mandacarubroker.services;

import com.mandacarubroker.domain.User;
import com.mandacarubroker.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorizationService implements UserDetailsService {
    @Autowired
    UserRepository repositoryUserLogin;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositoryUserLogin.findByLogin(username);
    }

    public User updateUserBalance(String id, double amount) {
        Optional<User> optionalUser = repositoryUserLogin.findById(id);

        User user = optionalUser.get();
        user.addToBalance(amount);
        return repositoryUserLogin.save(user);
    }

    public User withdraw(String id, double amount) {
        Optional<User> optionalUser = repositoryUserLogin.findById(id);

        User user = optionalUser.get();
        user.subtractFromBalance(amount);
        return repositoryUserLogin.save(user);
    }
    public List<User> getAllUser(){
        return repositoryUserLogin.findAll();
    }
}
