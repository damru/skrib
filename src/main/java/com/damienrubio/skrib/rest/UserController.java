package com.damienrubio.skrib.rest;

import com.damienrubio.skrib.model.User;
import com.damienrubio.skrib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by damien on 12/01/2017.
 */
@RestController
@RequestMapping(MappingConstants.USER)
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;

    /**
     * CRUD methods.
     */

    /**
     * Create a new user.
     * @param user to create.
     * @return created user.
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.save(user);
        HttpHeaders headers = generateHttpHeaders();
        return new ResponseEntity<User>(user, headers, HttpStatus.OK);
    }

    /**
     * Read a user.
     * @param idUser to read.
     * @return user.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> readUser(@PathVariable(name = "id") Long idUser) {
        User userConnected =
            userService.find(1L); // FIXME retrieve user from http header in order to create links relation for HATEOAS service
        User user = userService.find(idUser);
        HttpHeaders headers = generateHttpHeaders();
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, headers, HttpStatus.OK);
    }

    /**
     * Update a user.
     * @param idUser to update.
     * @param user with new datas.
     * @return updated user.
     */
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> updateUser(@PathVariable(name = "id") Long idUser, @RequestBody User user) {
        User userConnected =
            userService.find(1L); // FIXME retrieve user from http header in order to check if user has permission to update.

        userService.update(user);
        HttpHeaders headers = generateHttpHeaders();
        return new ResponseEntity<User>(user, headers, HttpStatus.OK);
    }

    /**
     * Delete a user.
     * @param idUser to delete.
     * @return only HttpStatus.
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ResponseEntity<User> deleteUser(@PathVariable(name = "id") Long idUser) {
        User user =
            userService.find(1L); // FIXME retrieve user from http header in order to check if user has permission to delete.

        userService.delete(idUser);
        HttpHeaders headers = generateHttpHeaders();
        return new ResponseEntity<User>(headers, HttpStatus.OK);
    }

    /**
     * End of CRUD methods.
     */
}
