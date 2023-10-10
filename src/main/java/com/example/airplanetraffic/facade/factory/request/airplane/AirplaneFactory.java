package com.example.airplanetraffic.facade.factory.request.airplane;

import com.example.airplanetraffic.model.entity.Airplane;

public interface AirplaneFactory {

    Airplane setUpNewAirplane(Long planeId, Long maxSpeed, Long maxAcceleration, Long heightChangesSpeed,
                              Long flightCourseSpeed, Long latitude, Long longitude, Long flightAltitude,
                              Long flightSpeed, Double course, Long flightNumber);
}
