package com.example.airplanetraffic.facade.factory.response.data.flight;

import com.example.airplanetraffic.facade.dto.response.data.flight.FlightData;
import com.example.airplanetraffic.model.entity.TemporaryPoint;
import com.example.airplanetraffic.model.entity.WayPoint;

import java.util.List;

public interface FlightDataFactory {

    FlightData setUpFlightResponse(Long number, List<TemporaryPoint> passedPoints,
                                   List<WayPoint> wayPoints);
}
