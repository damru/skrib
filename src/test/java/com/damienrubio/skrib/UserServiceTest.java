package com.damienrubio.skrib;

import com.damienrubio.skrib.exception.UserNotFoundException;
import com.damienrubio.skrib.exception.UserSettingsNotFoundException;
import com.damienrubio.skrib.model.User;
import com.damienrubio.skrib.model.UserSettings;
import com.damienrubio.skrib.repository.UserRepository;
import com.damienrubio.skrib.repository.UserSettingsRepository;
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
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserSettingsRepository userSettingsRepository;

    @InjectMocks
    private UserService userService = new UserService();

    @Test(expected = UserNotFoundException.class)
    public void get_unknown_user_should_return_exception() {
        when(userRepository.findOne(anyLong())).thenReturn(null);
        userService.getUser(1L);
    }

    @Test
    public void get_user_should_return_user() {
        User savedUser = UserFactory.randomUser();
        when(userRepository.findOne(anyLong())).thenReturn(savedUser);

        User user = userService.getUser(1L);
        assertTrue(user != null);
        assertTrue(user.getUsername().equals(savedUser.getUsername()));
    }

    @Test
    public void save_user_should_return_user() {
        User savedUser = UserFactory.randomUser();
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        User user = userService.saveUser(savedUser);
        assertTrue(user != null);
        assertTrue(user.getUsername().equals(savedUser.getUsername()));
    }

    @Test
    public void check_author_should_return_true() {
        User userAndAuthor = UserFactory.randomUser();

        assertTrue(userService.isAuthor(userAndAuthor, userAndAuthor));
    }

    @Test
    public void get_userSettings_should_return_userSettings() {
        User user = UserFactory.randomUser();
        when(userSettingsRepository.findByUser(any(User.class))).thenReturn(UserFactory.randomUserSettings(user));

        UserSettings userSettings = userService.getUserSettings(user);
        assertTrue(userSettings != null);
        assertTrue(userSettings.getUser() != null && userSettings.getUser().equals(user));
    }

    @Test(expected = UserSettingsNotFoundException.class)
    public void get_userSettings_from_unknown_user_should_return_exception() {
        when(userSettingsRepository.findByUser(any(User.class))).thenReturn(null);
        userService.getUserSettings(UserFactory.randomUser());
    }

}
