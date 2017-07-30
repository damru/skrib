package com.damienrubio.skrib;

import com.damienrubio.skrib.model.Position;
import org.apache.commons.lang3.RandomUtils;

/**
 * Created by damien on 30/07/2017.
 */
public class PositionFactory {

    public static Position randomPosition() {
        return Position.builder().altitude(RandomUtils.nextDouble()).latitude(RandomUtils.nextDouble()).longitude(RandomUtils.nextDouble())
                       .build();
    }

}
