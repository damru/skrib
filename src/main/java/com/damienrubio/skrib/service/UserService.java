package com.damienrubio.skrib.service;

import com.damienrubio.skrib.model.Message;
import com.damienrubio.skrib.model.User;
import com.damienrubio.skrib.model.UserSettings;
import com.damienrubio.skrib.repository.UserRepository;
import com.damienrubio.skrib.repository.UserSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by damien on 09/01/2017.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSettingsRepository userSettingsRepository;

    public boolean isAuthor(User user, Message message) {
        if (user != null && message != null && message.getAuthor() != null) {
            if (user.equals(message.getAuthor())) {
                return true;
            }
        }

        return false;
    }

    public User find(Long idUser) {
        User user = userRepository.findOne(idUser);
//        user.setSettings(getUserSettings(user));
        return user;
    }

    public UserSettings getUserSettings(User user) {
        return userSettingsRepository.findByUserId(user.getId());
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
