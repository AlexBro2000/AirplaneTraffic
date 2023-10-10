package com.example.airplanetraffic.facade;


import com.example.airplanetraffic.facade.dto.request.AddAirplaneRequest;
import com.example.airplanetraffic.facade.dto.request.data.WayPointData;
import com.example.airplanetraffic.facade.dto.response.GetFlightsResponse;
import com.example.airplanetraffic.facade.dto.response.GetRouteResponse;

import java.util.List;

public interface PlaneFacade {

    GetRouteResponse getRoute(Long planeId, List<WayPointData> wayPointDataList);

    void addNewPlane(AddAirplaneRequest addAirplaneRequest);

    GetFlightsResponse getFlights(Long planeId);
}
