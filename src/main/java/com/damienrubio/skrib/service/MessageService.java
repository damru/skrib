package com.damienrubio.skrib.service;

import com.damienrubio.skrib.SkribApplication;
import com.damienrubio.skrib.error.Criticity;
import com.damienrubio.skrib.error.InfoMessage;
import com.damienrubio.skrib.model.Message;
import com.damienrubio.skrib.model.User;
import com.damienrubio.skrib.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
     *
     * @param message
     */
    public void save(Message message) {
        this.checkDatas(message);
        if (!SkribApplication.contexte.hasError()) {
            messageRepository.save(message);
        }
    }

    /**
     * Retrieve a message.
     *
     * @param idMessage
     * @param user
     * @return
     */
    public Message readMessage(Long idMessage, User user) {
        Message m = messageRepository.findOne(idMessage);
        if (m != null) {
            if (userService.isAuthor(user, m) || this.isReachable(m, user)) {
                cleanAuthor(m);
            }
        }

        return m;
    }

    /**
     * Check if a message is reachable by the current user.
     *
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

    /**
     * Clean message's author to display only required information.
     *
     * @param m
     */
    private void cleanAuthor(Message m) {
        User author = new User();
        author.setId(m.getAuthor().getId());
        author.setUsername(m.getAuthor().getUsername());
        m.setAuthor(author);
    }

    /**
     * Check datas coherency in a message.
     *
     * @param message
     */
    private void checkDatas(Message message) {
        if (message.getAuthor() == null) {
            SkribApplication.contexte.addMessage(
                new InfoMessage(this.getClass().getSimpleName(), "Message", "author", null, "Author of the message cannot be null.",
                    Criticity.ERROR));
        }
        if (message.getBody() == null) {
            SkribApplication.contexte.addMessage(
                new InfoMessage(this.getClass().getSimpleName(), "Message", "body", null, "Body of the message cannot be null.",
                    Criticity.ERROR));
        }
        if (message.getDate() == null) {
            Date now = new Date();
            message.setDate(now);
            SkribApplication.contexte.addMessage(new InfoMessage(this.getClass().getSimpleName(), "Message", "Date", now.toString(),
                "Date has been defaulted to current date.", Criticity.INFO));
        }
        if (message.getPosition() == null) {
            if (message.getAuthor().getPosition() != null) {
                message.setPosition(message.getAuthor().getPosition());
                SkribApplication.contexte.addMessage(
                    new InfoMessage(this.getClass().getSimpleName(), "Message", "position", message.getPosition().toString(),
                        "Message location has been defaulted with author's location.", Criticity.WARNING));
            } else {
                SkribApplication.contexte.addMessage(
                    new InfoMessage(this.getClass().getSimpleName(), "Message", "position", null, "Position of the message cannot be null.",
                        Criticity.ERROR));
            }
        }
        if (message.getRayon() == null) {
            SkribApplication.contexte.addMessage(
                new InfoMessage(this.getClass().getSimpleName(), "Message", "rayon", null, "Rayon of action of the message cannot be null.",
                    Criticity.ERROR));
        }
    }

    public void updateMessage(Message message) {
        this.save(message);
    }

    public void deleteMessage(Long idMessage) {
        messageRepository.delete(idMessage);
    }
}
