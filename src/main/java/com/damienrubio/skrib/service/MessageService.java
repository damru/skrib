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

    /**
     * Save message in database.
     * @param message
     */
    public void save(Message message) {
        messageRepository.save(message);
    }

    /**
     * Retrieve a message
     * @param idMessage
     * @param user
     * @return
     */
    public Message readMessage(Long idMessage, User user) {
        Message m = messageRepository.findOne(idMessage);
        if (m != null) {
            if (userService.isAuthor(user, m) || this.isReachable(m, user)) {
                cleanAuthor(m);
                return m;
            }
        }

        return null;
    }

    /**
     * Clean message's author to display only required information.
     * @param m
     */
    private void cleanAuthor(Message m) {
        User author = new User();
        author.setId(m.getAuthor().getId());
        author.setUsername(m.getAuthor().getUsername());
        m.setAuthor(author);
    }

    /**
     * Check if a message is reachable by the current user.
     * @param message
     * @param user
     * @return
     */
    public boolean isReachable(Message message, User user) {
        double distanceBetweenUserAndMessage = positionService.distanceBetweenUserAndMessage(user, message);
        message.setDistance(distanceBetweenUserAndMessage);

        if (distanceBetweenUserAndMessage > message.getRayon() || distanceBetweenUserAndMessage > user.getSettings().getRayon()) {
            return false;
        }

        return true;

    }

}
