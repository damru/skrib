package com.damienrubio.skrib.api;

import com.damienrubio.skrib.model.Message;
import com.damienrubio.skrib.model.MessageDTO;
import com.damienrubio.skrib.model.Position;
import com.damienrubio.skrib.model.User;
import com.damienrubio.skrib.service.MessageService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by damien on 24/12/2016.
 */
@RestController
@RequestMapping("/messages/v1")
public class MessageResource {

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/{messageId}")
    public ResponseEntity<Message> viewMessage(@PathVariable(name = "messageId") @ApiParam(required = true) Long idMessage) {
        return ResponseEntity.ok().body(messageService.getMessage(idMessage));
    }

    @PostMapping
    public ResponseEntity createMessage(@RequestBody MessageDTO message, @RequestHeader User user, @RequestHeader Position userPosition) {
        Message newMessage = Message.builder().author(user).position(userPosition).body(message.getBody()).rayon(message.getRayon()).build();
        return ResponseEntity.ok().body(messageService.saveMessage(newMessage));
    }

}
