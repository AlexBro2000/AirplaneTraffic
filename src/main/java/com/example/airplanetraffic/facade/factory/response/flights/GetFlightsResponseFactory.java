package com.example.airplanetraffic.facade.factory.response.flights;

import com.example.airplanetraffic.facade.dto.response.GetFlightsResponse;
import com.example.airplanetraffic.model.entity.Flight;

import java.util.List;

public interface GetFlightsResponseFactory {

    GetFlightsResponse setUpGetFlightsResponse(List<Flight> flights);
}
