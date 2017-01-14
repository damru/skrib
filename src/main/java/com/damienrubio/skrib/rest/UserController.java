package com.damienrubio.skrib.rest;

import com.damienrubio.skrib.model.Message;
import com.damienrubio.skrib.model.User;
import com.damienrubio.skrib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by damien on 12/01/2017.
 */
@RestController
@RequestMapping(MappingConstants.USER)
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User viewUser(@PathVariable(name = "id") Long idUser) {
        return userService.find(idUser);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        userService.save(user);
        return user;
    }
}
