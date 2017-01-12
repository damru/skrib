package com.damienrubio.skrib.rest;

import com.damienrubio.skrib.model.Message;
import com.damienrubio.skrib.model.User;
import com.damienrubio.skrib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by damien on 12/01/2017.
 */
@RestController
@RequestMapping(MappingConstants.USER)
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}")
    public User viewUser(@PathVariable(name = "id") Long idUser) {
        return userService.find(idUser);
    }
}
