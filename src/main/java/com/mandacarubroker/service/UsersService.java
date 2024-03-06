package com.mandacarubroker.service;

import com.mandacarubroker.Users.RequestUserDTO;
import com.mandacarubroker.Users.UserRepository;
import com.mandacarubroker.Users.Users;
import org.springframework.stereotype.Service;

import jakarta.validation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsersService {
    private final UserRepository userRepository;

    public UsersService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users createUsers(final RequestUserDTO data){
        validateRequestUserDTO(data); // Validar os dados antes de criar o usuário
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

    private void validateRequestUserDTO(final RequestUserDTO data) {
        final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        final Validator validator = factory.getValidator();
        final Set<ConstraintViolation<RequestUserDTO>> violations = validator.validate(data);

        if (!violations.isEmpty()) {
            final StringBuilder errorMessage = new StringBuilder("Validation failed. Details: ");

            for (final ConstraintViolation<RequestUserDTO> violation : violations) {
                errorMessage.append(String.format("[%s: %s], ", violation.getPropertyPath(), violation.getMessage()));
            }

            errorMessage.delete(errorMessage.length() - 2, errorMessage.length());
            throw new ConstraintViolationException(errorMessage.toString(), violations);
        }
    }

}

