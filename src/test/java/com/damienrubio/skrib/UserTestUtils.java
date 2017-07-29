package com.damienrubio.skrib;

import com.damienrubio.skrib.model.DistanceUnit;
import com.damienrubio.skrib.model.Gender;
import com.damienrubio.skrib.model.User;
import com.damienrubio.skrib.model.UserSettings;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.text.RandomStringGenerator;

/**
 * Created by damien on 29/07/2017.
 */
public class UserTestUtils {

    public static String randomString() {
        return new RandomStringGenerator.Builder().withinRange('a', 'z').build().generate(8);
    }

    public static User randomUser() {
        return User.builder().idUser(RandomUtils.nextLong()).age(RandomUtils.nextInt()).email(randomString()).firstname(randomString())
                   .lastname(randomString()).username(randomString()).gender(Gender.FEMALE).password(randomString()).build();
    }

    public static UserSettings randomUserSettings(User user) {
        return UserSettings.builder().idUserSettings(RandomUtils.nextLong()).user(user).distanceUnit(DistanceUnit.METER).rayon(100L)
                           .build();
    }
}
