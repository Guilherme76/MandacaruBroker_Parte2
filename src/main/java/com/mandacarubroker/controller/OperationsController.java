package com.mandacarubroker.controller;
import com.mandacarubroker.domain.User;
import com.mandacarubroker.services.AuthorizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operations")
public class OperationsController {

        private final AuthorizationService authorizationService;

        public OperationsController(AuthorizationService authorizationService) {
            this.authorizationService = authorizationService;
        }

        @PutMapping("{id}/deposit")
        public ResponseEntity<User> updateUserBalance(@PathVariable final String id, @RequestBody double amount) {
            final User updatedUser = authorizationService.updateUserBalance(id, amount);
            return ResponseEntity.ok(updatedUser);
        }

        @PutMapping("{id}/withdraw")
        public ResponseEntity<User> withdraw(@PathVariable final String id, @RequestBody double amount) {
            final User updatedUser = authorizationService.withdraw(id, amount);
            return ResponseEntity.ok(updatedUser);
        }

}

