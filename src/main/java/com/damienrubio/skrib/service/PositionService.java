package com.damienrubio.skrib.service;

import com.damienrubio.skrib.enums.DistanceUnit;
import com.damienrubio.skrib.model.Message;
import com.damienrubio.skrib.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by damien on 09/01/2017.
 */
@Service
public class PositionService {

    /**
     *
     * @param user
     * @param message
     * @return
     */
    public double distanceBetweenUserAndMessage(User user, Message message) {
        return this.distance(user.getPosition().getLatitude(), message.getPosition().getLatitude(), user.getPosition().getLongitude(), message.getPosition().getLongitude(),
            user.getPosition().getAltitude(), message.getPosition().getAltitude(), user.getSettings().getDistanceUnit());
    }

    /**
     * Calculate distance between two points in latitude and longitude taking into account height difference.
     * If you are not interested in height difference pass 0.0.
     * Uses Haversine method as its base.
     * Uses user's DistanceUnit.
     * @param lat1
     * @param lat2
     * @param lon1
     * @param lon2
     * @param el1
     * @param el2
     * @param unit
     * @return Distance in meters.
     */
    public double distance(double lat1, double lat2, double lon1,
        double lon2, double el1, double el2, DistanceUnit unit) {

        final int R = 6371; // Radius of the earth

        Double latDistance = Math.toRadians(lat2 - lat1);
        Double lonDistance = Math.toRadians(lon2 - lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);
        distance = Math.sqrt(distance);

        if (DistanceUnit.MILE.equals(unit)) {
            distance = distance / unit.getInMeters();
        }
        return distance;
    }

}
