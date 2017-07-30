package com.damienrubio.skrib;

import com.damienrubio.skrib.model.DistanceUnit;
import com.damienrubio.skrib.model.Gender;
import com.damienrubio.skrib.model.User;
import com.damienrubio.skrib.model.UserSettings;
import org.apache.commons.lang3.RandomUtils;

/**
 * Created by damien on 30/07/2017.
 */
public class UserFactory {

    public static User randomUser() {
        return User.builder().idUser(RandomUtils.nextLong()).age(RandomUtils.nextInt()).email(TestUtils.randomString())
                   .firstname(TestUtils.randomString()).lastname(TestUtils.randomString()).username(TestUtils.randomString())
                   .gender(Gender.FEMALE).password(TestUtils.randomString()).build();
    }

    public static UserSettings randomUserSettings(User user) {
        return UserSettings.builder().idUserSettings(RandomUtils.nextLong()).user(user).distanceUnit(DistanceUnit.METER).rayon(100L)
                           .build();
    }

}
