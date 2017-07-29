package com.damienrubio.skrib.api;

import com.damienrubio.skrib.model.User;
import com.damienrubio.skrib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by damien on 12/01/2017.
 */
@RestController
@RequestMapping("/users/v1")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> viewUser(@PathVariable(name = "userId") Long idUser) {
        User user = userService.getUser(idUser);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User userCreated = userService.saveUser(user);
        return ResponseEntity.ok().body(userCreated);
    }
}
