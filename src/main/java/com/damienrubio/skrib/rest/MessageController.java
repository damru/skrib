package com.damienrubio.skrib.rest;

import com.damienrubio.skrib.model.Message;
import com.damienrubio.skrib.model.User;
import com.damienrubio.skrib.repository.UserRepository;
import com.damienrubio.skrib.service.MessageService;
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
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/{id}")
    public Message readMessage(@PathVariable(name = "id") Long idMessage, @RequestBody User user) {
        return messageService.readMessage(idMessage, user);
    }

    @RequestMapping(value = "/{id}")
    public Message readMessage(@PathVariable(name = "id") Long idMessage) {
        User user = userRepository.findOne(1L);
        return messageService.readMessage(idMessage, user);
    }

}
