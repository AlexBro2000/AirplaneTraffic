package com.example.airplanetraffic.facade.factory.request.waypoint;

import com.example.airplanetraffic.model.entity.WayPoint;

public interface WayPointFactory {

    WayPoint setUpWayPoint(Long latitude, Long longitude, Long flightAltitude, Long flightSpeed);
}
