package com.damienrubio.skrib.service;

import com.damienrubio.skrib.exception.UserNotFoundException;
import com.damienrubio.skrib.exception.UserSettingsNotFoundException;
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

    public boolean isAuthor(User user, User messageAuthor) {
        return user != null && messageAuthor != null && user.equals(messageAuthor);
    }

    /**
     * Get a user.
     *
     * @param idUser
     * @return user
     */
    public User getUser(Long idUser) {
        User user = userRepository.findOne(idUser);
        if (user == null) {
            throw UserNotFoundException.builder().id(idUser).build();
        }
        return user;
    }

    public UserSettings getUserSettings(User user) {
        UserSettings userSettings = userSettingsRepository.findByUser(user);
        if (userSettings == null) {
            throw UserSettingsNotFoundException.builder().id(user.getIdUser()).build();
        }
        return userSettings;
    }

    /**
     * Save user in database.
     *
     * @param user
     * @return new user
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
