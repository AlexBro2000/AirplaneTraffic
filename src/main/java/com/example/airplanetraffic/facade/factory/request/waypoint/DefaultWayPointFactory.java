package com.example.airplanetraffic.facade.factory.request.waypoint;

import com.example.airplanetraffic.model.entity.WayPoint;
import org.springframework.stereotype.Component;

@Component
public class DefaultWayPointFactory implements WayPointFactory {
    @Override
    public WayPoint setUpWayPoint(Long latitude, Long longitude, Long flightAltitude, Long flightSpeed) {
        WayPoint wayPoint = new WayPoint();
        wayPoint.setLatitude(latitude);
        wayPoint.setLongitude(longitude);
        wayPoint.setFlightAltitude(flightAltitude);
        wayPoint.setFlightSpeed(flightSpeed);
        return wayPoint;
    }
}
