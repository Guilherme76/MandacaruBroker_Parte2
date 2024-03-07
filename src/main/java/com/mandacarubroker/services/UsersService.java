package com.mandacarubroker.services;

import com.mandacarubroker.helpers.RequestUserDTO;
import com.mandacarubroker.users.UsersRepository;
import com.mandacarubroker.users.Users;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository userRepository;

    public UsersService(final UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users createUsers(final RequestUserDTO data){
        final Users newAction = new Users(data);
        return userRepository.save(newAction);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    };

    public Optional<Object> updateUser(String id, Users updateUser) {
        return userRepository.findById(id).map(users -> {
            users.setUsername(updateUser.getUsername());
            users.setPassword(updateUser.getPassword());
            users.setEmail(updateUser.getEmail());
            users.setFirstName(updateUser.getFirstName());
            users.setLastName(updateUser.getLastName());
            users.setBirthDate(updateUser.getBirthDate());
            users.setBalance(updateUser.getBalance());
            return userRepository.save(users);
        });
    };

    public void deleteUser(final String id) {
        userRepository.deleteById(id);
    }
}

