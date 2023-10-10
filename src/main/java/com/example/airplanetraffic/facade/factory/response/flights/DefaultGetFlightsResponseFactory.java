package com.example.airplanetraffic.facade.factory.response.flights;

import com.example.airplanetraffic.facade.dto.response.GetFlightsResponse;
import com.example.airplanetraffic.facade.factory.response.data.flight.FlightDataFactory;
import com.example.airplanetraffic.model.entity.Flight;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultGetFlightsResponseFactory implements GetFlightsResponseFactory {

    @Resource
    private FlightDataFactory flightDataFactory;

    @Override
    public GetFlightsResponse setUpGetFlightsResponse(List<Flight> flights) {
        GetFlightsResponse getFlightsResponse = new GetFlightsResponse();
        getFlightsResponse.setFlights(flights
                .stream()
                .map(flight -> flightDataFactory.setUpFlightResponse(flight.getNumber(),
                        flight.getPassedPoints(), flight.getWayPoints(), flight.getPassedPoints().size() + " s")).toList());
        return getFlightsResponse;
    }
}
