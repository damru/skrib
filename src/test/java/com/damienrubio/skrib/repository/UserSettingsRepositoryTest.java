package com.damienrubio.skrib.repository;

import com.damienrubio.skrib.UserFactory;
import com.damienrubio.skrib.model.DistanceUnit;
import com.damienrubio.skrib.model.User;
import com.damienrubio.skrib.model.UserSettings;
import com.damienrubio.skrib.repository.UserSettingsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by damien on 29/07/2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserSettingsRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserSettingsRepository userSettingsRepository;

    @Test
    public void should_return_userSettings_from_user() {
        User user = UserFactory.randomUser();
        user.setIdUser(0);
        testEntityManager.persist(user);
        testEntityManager.persist(UserSettings.builder().distanceUnit(DistanceUnit.CENTIMETER).rayon(1L).user(user).build());

        UserSettings userSettings = userSettingsRepository.findByUser(user);

        assertTrue(userSettings != null);
        assertTrue(userSettings.getUser().getUsername().equals(user.getUsername()));
    }

    @Test
    public void should_return_userSettings_from_userId() {
        User user = UserFactory.randomUser();
        user.setIdUser(0);
        testEntityManager.persist(user);
        testEntityManager.persist(UserSettings.builder().distanceUnit(DistanceUnit.CENTIMETER).rayon(1L).user(user).build());

        UserSettings userSettings = userSettingsRepository.findByUser_IdUser(user.getIdUser());

        assertTrue(userSettings != null);
        assertTrue(userSettings.getUser().getUsername().equals(user.getUsername()));
    }

}
