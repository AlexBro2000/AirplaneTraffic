package com.example.airplanetraffic.facade.factory.request.airplane;

import com.example.airplanetraffic.model.entity.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultAirplaneFactory implements AirplaneFactory {
    @Override
    public Airplane setUpNewAirplane(Long planeId, Long maxSpeed, Long maxAcceleration,
                                     Long heightChangesSpeed, Long flightCourseSpeed, Long latitude,
                                     Long longitude, Long flightAltitude, Long flightSpeed, Double course,
                                     Long flightNumber) {
        Airplane airplane = new Airplane();
        AirplaneCharacteristic characteristic = new AirplaneCharacteristic();
        TemporaryPoint position = new TemporaryPoint();
        Flight flight = new Flight();
        List<Flight> flights = new ArrayList<>();
        List<TemporaryPoint> passedPoints = new ArrayList<>();
        List<WayPoint> wayPoints = new ArrayList<>();

        airplane.setPlaneId(planeId);
        characteristic.setMaxSpeed(maxSpeed);
        characteristic.setMaxAcceleration(maxAcceleration);
        characteristic.setHeightChangesSpeed(heightChangesSpeed);
        characteristic.setFlightCourseSpeed(flightCourseSpeed);
        airplane.setAirplaneCharacteristic(characteristic);
        position.setLatitude(latitude);
        position.setLongitude(longitude);
        position.setFlightAltitude(flightAltitude);
        position.setFlightSpeed(flightSpeed);
        position.setCourse(course);
        airplane.setPosition(position);
        flight.setNumber(flightNumber);
        passedPoints.add(position);
        flight.setPassedPoints(passedPoints);
        flight.setWayPoints(wayPoints);
        flights.add(flight);
        airplane.setFlights(flights);
        return airplane;
    }
}
