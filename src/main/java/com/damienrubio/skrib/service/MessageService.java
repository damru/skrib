package com.damienrubio.skrib.service;

import com.damienrubio.skrib.exception.MessageNotFoundException;
import com.damienrubio.skrib.model.DistanceUnit;
import com.damienrubio.skrib.model.Message;
import com.damienrubio.skrib.model.Position;
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
     *
     * @param message
     * @return new message
     */
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    /**
     * Get a message.
     *
     * @param idMessage
     * @return message
     */
    public Message getMessage(Long idMessage) {
        Message message = messageRepository.findOne(idMessage);
        if (message == null) {
            throw MessageNotFoundException.builder().id(idMessage).build();
        }
        return message;
    }

    /**
     * Check if a message is reachable by the current user.
     *
     * @param message
     * @param userPosition
     * @param distanceMax
     * @param unit
     * @return
     */
    public boolean isReachable(Message message, Position userPosition, Long distanceMax, DistanceUnit unit) {
        double distanceBetweenUserAndMessage = positionService.distanceBetweenUserAndMessage(unit, userPosition, message.getPosition());
        message.setDistance(distanceBetweenUserAndMessage);
        return distanceBetweenUserAndMessage <= message.getRayon() && distanceBetweenUserAndMessage <= distanceMax;

    }

}
