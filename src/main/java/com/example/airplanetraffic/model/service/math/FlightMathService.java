package com.example.airplanetraffic.model.service.math;

import com.example.airplanetraffic.model.entity.TemporaryPoint;
import com.example.airplanetraffic.model.entity.WayPoint;

import java.util.List;

public interface FlightMathService {

    List<TemporaryPoint> calculateFlightRoute(WayPoint startPoint, WayPoint endPoint);
}
