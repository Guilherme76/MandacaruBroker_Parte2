package com.mandacarubroker.controller;
import com.mandacarubroker.Users.RequestUserDTO;
import com.mandacarubroker.service.UsersService;
import com.mandacarubroker.Users.Users;
import com.mandacarubroker.domain.stock.RequestStockDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<Users> createStock(@RequestBody final RequestUserDTO data) {
        final Users createUser = usersService.createUsers(data);
        return ResponseEntity.ok(createUser);
    }

    @PutMapping("{id}")
    public Users updateUser(@PathVariable final String id, @RequestBody final Users updateUser){
        return (Users) usersService.updateUser(id, updateUser).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable final String id){
        usersService.deleteUser(id);
    }

}
