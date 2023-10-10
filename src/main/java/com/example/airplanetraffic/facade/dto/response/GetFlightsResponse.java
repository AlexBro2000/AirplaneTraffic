package com.example.airplanetraffic.facade.dto.response;

import com.example.airplanetraffic.facade.dto.response.data.flight.FlightData;
import lombok.Data;

import java.util.List;

@Data
public class GetFlightsResponse {

    private List<FlightData> flights;
}
