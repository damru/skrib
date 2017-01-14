package com.damienrubio.skrib.rest;

import com.damienrubio.skrib.model.Message;
import com.damienrubio.skrib.model.User;
import com.damienrubio.skrib.service.MessageService;
import com.damienrubio.skrib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by damien on 24/12/2016.
 */
@RestController
@RequestMapping(MappingConstants.MESSAGE)
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public Message viewMessage(@PathVariable(name = "id") Long idMessage, @RequestHeader User user) {
//        return messageService.readMessage(idMessage, user);
//    }

//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public Message createMessage(@RequestBody Message message, @RequestHeader User user) {
//        message.setAuthor(user);
//        message.setPosition(user.getPosition());
//        messageService.save(message);
//        return message;
//    }

    /**
     * TEST PURPOSE
     */

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Message viewMessage(@PathVariable(name = "id") Long idMessage) {
        User user = userService.find(1L);
        return messageService.readMessage(idMessage, user);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Message createMessage(@RequestBody Message message) {
        User user = userService.find(1L);
        message.setAuthor(user);
        message.setPosition(user.getPosition());
        messageService.save(message);
        return message;
    }

}
