package com.damienrubio.skrib.service;

import com.damienrubio.skrib.model.Message;
import com.damienrubio.skrib.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by damien on 09/01/2017.
 */
@Service
public class UserService {

    public boolean isAuthor(User user, Message message) {
        if (user == null || message == null || message.getAuthor() == null) {
            return false;
        }

        if (user.equals(message.getAuthor())) {
            return true;
        }

        return false;
    }
}
