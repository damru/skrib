package com.damienrubio.skrib.service;

import com.damienrubio.skrib.model.DistanceUnit;
import com.damienrubio.skrib.model.Position;
import org.springframework.stereotype.Service;

/**
 * Created by damien on 09/01/2017.
 */
@Service
public class PositionService {

    /**
     * @param unit
     * @param userPosition
     * @param messagePosition
     * @return
     */
    public double distanceBetweenUserAndMessage(DistanceUnit unit, Position userPosition, Position messagePosition) {
        return this.distance(userPosition.getLatitude(), messagePosition.getLatitude(), userPosition.getLongitude(),
                             messagePosition.getLongitude(), userPosition.getAltitude(), messagePosition.getAltitude(), unit);
    }

    /**
     * Calculate distance between two points in latitude and longitude taking into account height difference.
     * If you are not interested in height difference pass 0.0.
     * Uses Haversine method as its base.
     * Uses user's DistanceUnit.
     *
     * @param lat1
     * @param lat2
     * @param lon1
     * @param lon2
     * @param height1
     * @param height2
     * @param unit
     * @return Distance in meters.
     */
    public double distance(double lat1, double lat2, double lon1, double lon2, double height1, double height2, DistanceUnit unit) {

        final int R = 6371; // Radius of the earth

        Double latDistance = Math.toRadians(lat2 - lat1);
        Double lonDistance = Math.toRadians(lon2 - lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = height1 - height2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);
        distance = Math.sqrt(distance);

        return distance / unit.getInMeters();
    }

}
