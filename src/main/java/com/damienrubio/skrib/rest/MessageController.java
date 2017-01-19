package com.damienrubio.skrib.rest;

import com.damienrubio.skrib.model.Message;
import com.damienrubio.skrib.model.Position;
import com.damienrubio.skrib.model.User;
import com.damienrubio.skrib.service.MessageService;
import com.damienrubio.skrib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by damien on 24/12/2016.
 */
@RestController
@RequestMapping(MappingConstants.MESSAGE)
public class MessageController extends AbstractController {

    @Autowired
    private MessageService messageService;

    /**
     * Create a new message.
     *
     * @param message to create.
     * @return created message.
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        messageService.save(message);
        HttpHeaders headers = generateHttpHeaders();
        return new ResponseEntity<Message>(message, headers, HttpStatus.OK);
    }

    /**
     * Read a message.
     *
     * @param idMessage to read.
     * @param userPosition We need user position and id to determine if the message can ve viewed.
     * @return message.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Message> readMessage(@PathVariable(name = "id") Long idMessage, @RequestBody Position userPosition) {
        User user = userService.find(1L); // FIXME retrieve user from http header in order to create links relation for HATEOAS service
        user.setPosition(userPosition);
        Message message = messageService.readMessage(idMessage, user);
        HttpHeaders headers = generateHttpHeaders();
        if (message == null) {
            return new ResponseEntity<Message>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Message>(message, headers, HttpStatus.OK);
    }

    @Autowired
    private UserService userService;

    /**
     * Update a message.
     * @param idMessage to update.
     * @param message with new datas.
     * @return updated message.
     */
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Message> updateMessage(@PathVariable(name = "id") Long idMessage, @RequestBody Message message) {
        User user = userService.find(1L); // FIXME retrieve user from http header in order check if user can update message
        messageService.updateMessage(message);
        HttpHeaders headers = generateHttpHeaders();
        if (message == null) {
            return new ResponseEntity<Message>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Message>(message, headers, HttpStatus.OK);
    }

    /**
     * Delete a message.
     * @param idMessage to delete.
     * @return only HttpStatus.
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ResponseEntity<Message> deleteMessage(@PathVariable(name = "id") Long idMessage) {
        User user = userService.find(1L); // FIXME retrieve user from http header in order check if user can delete message
        messageService.deleteMessage(idMessage);
        HttpHeaders headers = generateHttpHeaders();
        return new ResponseEntity<Message>(headers, HttpStatus.OK);
    }

}
