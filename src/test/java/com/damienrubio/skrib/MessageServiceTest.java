package com.damienrubio.skrib;

import com.damienrubio.skrib.exception.MessageNotFoundException;
import com.damienrubio.skrib.model.DistanceUnit;
import com.damienrubio.skrib.model.Message;
import com.damienrubio.skrib.model.Position;
import com.damienrubio.skrib.repository.MessageRepository;
import com.damienrubio.skrib.service.MessageService;
import com.damienrubio.skrib.service.PositionService;
import com.damienrubio.skrib.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Created by damien on 29/07/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {

    @Mock
    private PositionService positionService;

    @Mock
    private UserService userService;

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageService messageService;

    @Test
    public void save_message_should_return_message() {
        Message savedMessage = MessageFactory.randomMessage();
        when(messageRepository.save(any(Message.class))).thenReturn(savedMessage);

        Message message = messageService.saveMessage(savedMessage);
        assertTrue(message != null);
        assertTrue(message.getIdMessage() == savedMessage.getIdMessage());
        assertTrue(message.getBody() == savedMessage.getBody());
    }

    @Test(expected = MessageNotFoundException.class)
    public void get_unknown_message_should_return_exception() {
        when(messageRepository.findOne(anyLong())).thenReturn(null);
        messageService.getMessage(0L);
    }

    @Test
    public void get_message_should_return_message() {
        Message savedMessage = MessageFactory.randomMessage();
        when(messageRepository.findOne(anyLong())).thenReturn(savedMessage);

        Message message = messageService.getMessage(0L);
        assertTrue(message != null);
        assertTrue(message.getIdMessage() == savedMessage.getIdMessage());
        assertTrue(message.getBody() == savedMessage.getBody());
    }

    @Test
    public void message_in_range_should_return_true() {
        when(positionService.distanceBetweenUserAndMessage(any(DistanceUnit.class), any(Position.class), any(Position.class)))
            .thenReturn(10.0);
        Message message = MessageFactory.randomMessage();
        message.setRayon(50L);
        Position position = message.getPosition();
        assertTrue(messageService.isReachable(message, position, 50L, DistanceUnit.METER));
    }

}
