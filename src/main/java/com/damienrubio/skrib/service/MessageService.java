package com.damienrubio.skrib.service;

import com.damienrubio.skrib.model.Message;
import com.damienrubio.skrib.model.User;
import com.damienrubio.skrib.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by damien on 24/12/2016.
 */
@Service
public class MessageService {

    @Autowired
    private PositionService positionService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageRepository messageRepository;

    public void save(Message message) {
    }

    public Message readMessage(Long idMessage, User user) {
        Message m = messageRepository.findOne(idMessage);
        if (m == null) {
            return null;
        }

        if (userService.isAuthor(user, m) || this.isReachable(m, user)) {
            return m;
        }

        return null;
    }

    public boolean isReachable(Message message, User user) {
        Long distanceBetweenPositionAndMessage =
            positionService.distanceBetweenPositionAndMessage(user.getPosition(), message.getPosition());

        if (distanceBetweenPositionAndMessage > message.getRayon() || distanceBetweenPositionAndMessage > user.getRayon()
            || message.getRayon() < user.getRayon()) {
            return false;
        }

        return true;

    }

}
