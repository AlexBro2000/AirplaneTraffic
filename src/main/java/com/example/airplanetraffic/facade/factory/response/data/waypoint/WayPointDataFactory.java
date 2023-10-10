package com.example.airplanetraffic.facade.factory.response.data.waypoint;

import com.example.airplanetraffic.facade.dto.response.data.waypoint.WayPointData;

public interface WayPointDataFactory {

    WayPointData setUpWayPointResponse(Long latitude, Long longitude, Long flightAltitude, Long flightSpeed);
}
