package com.example.airplanetraffic.facade.factory.response.data.flight;

import com.example.airplanetraffic.facade.dto.response.data.flight.FlightData;
import com.example.airplanetraffic.facade.factory.response.data.temporarypoint.TemporaryPointDataFactory;
import com.example.airplanetraffic.facade.factory.response.data.waypoint.WayPointDataFactory;
import com.example.airplanetraffic.model.entity.TemporaryPoint;
import com.example.airplanetraffic.model.entity.WayPoint;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultFlightDataFactory implements FlightDataFactory {

    @Resource
    private TemporaryPointDataFactory temporaryPointDataFactory;
    @Resource
    private WayPointDataFactory wayPointDataFactory;

    @Override
    public FlightData setUpFlightResponse(Long number, List<TemporaryPoint> passedPoints, List<WayPoint> wayPoints) {
        FlightData flightData = new FlightData();

        flightData.setNumber(number);
        flightData.setPassedPoints(passedPoints
                .stream()
                .map(temporaryPoint -> temporaryPointDataFactory
                        .setUpTemporaryPointData(temporaryPoint.getLatitude(), temporaryPoint.getLongitude(),
                                temporaryPoint.getFlightAltitude(), temporaryPoint.getFlightSpeed(),
                                temporaryPoint.getCourse())).toList());
        flightData.setWayPoints(wayPoints
                .stream()
                .map(wayPoint -> wayPointDataFactory
                        .setUpWayPointResponse(wayPoint.getLatitude(), wayPoint.getLongitude(),
                                wayPoint.getFlightAltitude(), wayPoint.getFlightSpeed())).toList());
        return flightData;
    }
}
