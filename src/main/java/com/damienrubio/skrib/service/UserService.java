package com.damienrubio.skrib.service;

import com.damienrubio.skrib.model.Message;
import com.damienrubio.skrib.model.User;
import com.damienrubio.skrib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by damien on 09/01/2017.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean isAuthor(User user, Message message) {
        if (user == null || message == null || message.getAuthor() == null) {
            return false;
        }

        if (user.equals(message.getAuthor())) {
            return true;
        }

        return false;
    }

    public User find(Long idUser) {
        return userRepository.findOne(idUser);
    }
}
