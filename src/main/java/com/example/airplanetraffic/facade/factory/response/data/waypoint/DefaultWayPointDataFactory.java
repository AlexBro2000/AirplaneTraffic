package com.example.airplanetraffic.facade.factory.response.data.waypoint;

import com.example.airplanetraffic.facade.dto.response.data.waypoint.WayPointData;
import org.springframework.stereotype.Component;

@Component
public class DefaultWayPointDataFactory implements WayPointDataFactory {

    @Override
    public WayPointData setUpWayPointResponse(Long latitude, Long longitude, Long flightAltitude, Long flightSpeed) {
        WayPointData wayPointData = new WayPointData();
        wayPointData.setLatitude(latitude);
        wayPointData.setLongitude(longitude);
        wayPointData.setFlightAltitude(flightAltitude);
        wayPointData.setFlightSpeed(flightSpeed);
        return wayPointData;
    }
}
