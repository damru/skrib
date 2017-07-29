package com.damienrubio.skrib;

import com.damienrubio.skrib.model.DistanceUnit;
import com.damienrubio.skrib.model.Position;
import com.damienrubio.skrib.service.PositionService;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by damien on 29/07/2017.
 */
public class PositionServiceTest {

    private static final PositionService positionService = new PositionService();

    private static final Position PARIS_POSITION = new Position(48.51, 2.21, 0);
    private static final Position MONTREAL_POSITION = new Position(45.30, -73.33, 0);
    private static final int RESULT_IN_KM = 5509;

    @Test
    public void should_return_distance_between_paris_and_montreal_in_km() {
        int distance = (int) positionService
            .distance(PARIS_POSITION.getLatitude(), MONTREAL_POSITION.getLatitude(), PARIS_POSITION.getLongitude(),
                      MONTREAL_POSITION.getLongitude(), PARIS_POSITION.getAltitude(), MONTREAL_POSITION.getAltitude(),
                      DistanceUnit.KILOMETER);

        assertTrue(RESULT_IN_KM == distance);
    }

    @Test
    public void should_return_distance_between_a_message_in_paris_and_a_user_in_montreal_in_km() {
        int distance = (int) positionService.distanceBetweenUserAndMessage(DistanceUnit.KILOMETER, MONTREAL_POSITION, PARIS_POSITION);

        assertTrue(RESULT_IN_KM == distance);
    }

}
