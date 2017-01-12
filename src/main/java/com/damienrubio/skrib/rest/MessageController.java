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

    @RequestMapping(method = RequestMethod.POST, value = "/{id}")
    public Message viewMessage(@PathVariable(name = "id") Long idMessage, @RequestBody User user) {
        return messageService.readMessage(idMessage, user);
    }

    @RequestMapping(value = "/{id}")
    public Message viewMessage(@PathVariable(name = "id") Long idMessage) {
        User user = userService.find(1L);
        return messageService.readMessage(idMessage, user);
    }

}
