package com.damienrubio.skrib;

import com.damienrubio.skrib.model.Message;
import org.apache.commons.lang3.RandomUtils;

/**
 * Created by damien on 30/07/2017.
 */
public class MessageFactory {

    public static Message randomMessage() {
        return Message.builder().idMessage(RandomUtils.nextLong()).body(TestUtils.randomString()).rayon(RandomUtils.nextLong())
                      .author(UserFactory.randomUser()).position(PositionFactory.randomPosition()).build();
    }

}
