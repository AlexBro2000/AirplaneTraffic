package com.example.airplanetraffic.facade;

import com.example.airplanetraffic.facade.dto.response.GetFlightsResponse;
import com.example.airplanetraffic.facade.exception.CommonException;
import com.example.airplanetraffic.facade.factory.request.airplane.AirplaneFactory;
import com.example.airplanetraffic.facade.factory.response.flights.GetFlightsResponseFactory;
import com.example.airplanetraffic.facade.factory.response.route.GetRouteResponseFactory;
import com.example.airplanetraffic.facade.factory.request.waypoint.WayPointFactory;
import com.example.airplanetraffic.facade.dto.request.AddAirplaneRequest;
import com.example.airplanetraffic.facade.dto.request.data.WayPointData;
import com.example.airplanetraffic.facade.dto.response.GetRouteResponse;
import com.example.airplanetraffic.facade.validation.airplane.AddAirplaneRequestValidator;
import com.example.airplanetraffic.facade.validation.waypoint.WayPointDataValidator;
import com.example.airplanetraffic.model.entity.*;
import com.example.airplanetraffic.model.service.airplane.AirplaneService;
import com.example.airplanetraffic.model.service.util.FlightNumberService;
import com.example.airplanetraffic.model.service.math.FlightMathService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DefaultPlaneFacade implements PlaneFacade {

    @Resource
    private AirplaneService airplaneService;
    @Resource
    private FlightMathService flightMathService;
    @Resource
    private AirplaneFactory airplaneFactory;
    @Resource
    private WayPointFactory wayPointFactory;
    @Resource
    private GetRouteResponseFactory getRouteResponseFactory;
    @Resource
    private GetFlightsResponseFactory flightsResponseFactory;
    @Resource
    private FlightNumberService flightNumberService;
    @Resource
    private AddAirplaneRequestValidator addAirplaneRequestValidator;
    @Resource
    private WayPointDataValidator wayPointDataValidator;

    @Override
    public GetRouteResponse getRoute(Long planeId, List<WayPointData> wayPointDataList) {
        Airplane airplane = airplaneService.findByPlaneId(planeId)
                .orElseThrow(() -> new CommonException("Airplane with plane id " + planeId + " is not found!"));
        wayPointDataList.forEach(wayPoint -> wayPointDataValidator.validate(wayPoint, airplane
                .getAirplaneCharacteristic()));

        List<WayPoint> wayPoints = wayPointDataList.stream().map(wayPointData -> wayPointFactory
                .setUpWayPoint(wayPointData.getLatitude(), wayPointData.getLongitude(),
                        wayPointData.getFlightAltitude(), wayPointData.getFlightSpeed())).toList();

        List<WayPoint> routePlan = new ArrayList<>(wayPoints);
        setUpStartPosition(airplane.getPosition(), routePlan);

        List<TemporaryPoint> temporaryPoints = calculatePlaneRoute(routePlan);
        updateAirplaneFlights(airplane, wayPoints, temporaryPoints);

        return getRouteResponseFactory.setUpGetRouteResponse(temporaryPoints);

    }

    @Override
    public void addNewPlane(AddAirplaneRequest addAirplaneRequest) {
        addAirplaneRequestValidator.validate(addAirplaneRequest);

        Long planeId = addAirplaneRequest.getPlaneId();
        if (airplaneService.findByPlaneId(planeId).isPresent()) {
            throw new CommonException("Airplane with plane id " + planeId + " is alreadyExist!");
        }

        airplaneService.save(airplaneFactory.setUpNewAirplane(addAirplaneRequest.getPlaneId(),
                addAirplaneRequest.getMaxSpeed(), addAirplaneRequest.getMaxAcceleration(),
                addAirplaneRequest.getHeightChangesSpeed(),
                addAirplaneRequest.getFlightCourseSpeed(), addAirplaneRequest.getLatitude(),
                addAirplaneRequest.getLongitude(), addAirplaneRequest.getFlightAltitude(),
                addAirplaneRequest.getFlightSpeed(), addAirplaneRequest.getCourse(),
                flightNumberService.generateFlightNumber()));
    }

    @Override
    public GetFlightsResponse getFlights(Long planeId) {
        Airplane airplane = airplaneService.findByPlaneId(planeId)
                .orElseThrow(() -> new CommonException("Airplane with plane id " + planeId + " is not found!"));
        return flightsResponseFactory.setUpGetFlightsResponse(airplane.getFlights());
    }

    private void setUpStartPosition(TemporaryPoint position, List<WayPoint> wayPoints) {
        wayPoints.add(0, startPosition(position));
    }

    private WayPoint startPosition(TemporaryPoint currentPosition) {
        WayPoint startPosition = new WayPoint();
        startPosition.setLatitude(currentPosition.getLatitude());
        startPosition.setLongitude(currentPosition.getLongitude());
        startPosition.setFlightSpeed(currentPosition.getFlightSpeed());
        startPosition.setFlightAltitude(currentPosition.getFlightAltitude());
        return startPosition;
    }

    private List<TemporaryPoint> calculatePlaneRoute(List<WayPoint> wayPoints) {
        return wayPoints.stream().flatMap(startPoint -> {
            int startIndex = wayPoints.indexOf(startPoint);
            int endIndex = startIndex + 1;

            if (endIndex >= wayPoints.size()) {
                return Stream.empty();
            }

            WayPoint endPoint = wayPoints.get(endIndex);
            List<TemporaryPoint> segmentRoute = flightMathService
                    .calculateFlightRoute(startPoint, endPoint);

            if (startIndex > 0) {
                segmentRoute.remove(0);
            }

            return segmentRoute.stream();
        }).collect(Collectors.toList());
    }

    private void updateAirplaneFlights(Airplane airplane, List<WayPoint> wayPoints, List<TemporaryPoint> passedPoints) {
        Flight flight = new Flight();
        flight.setNumber(flightNumberService.generateFlightNumber());
        flight.setWayPoints(wayPoints);
        flight.setPassedPoints(passedPoints);
        List<Flight> flights = airplane.getFlights();
        flights.add(flight);
        airplane.setFlights(flights);
        airplaneService.save(airplane);
    }
}
