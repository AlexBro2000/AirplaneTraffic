package com.example.airplanetraffic.cotroller;

import com.example.airplanetraffic.facade.PlaneFacade;
import com.example.airplanetraffic.facade.dto.request.AddAirplaneRequest;
import com.example.airplanetraffic.facade.dto.request.CalculateRouteRequest;
import com.example.airplanetraffic.facade.dto.response.GetFlightsResponse;
import com.example.airplanetraffic.facade.dto.response.GetRouteResponse;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/airplane")
public class PlaneController {

    @Resource
    private PlaneFacade planeFacade;


    @PostMapping("/add")
    public HttpStatus addNewPlane(@RequestBody AddAirplaneRequest addAirplaneRequest) {
        planeFacade.addNewPlane(addAirplaneRequest);
        return HttpStatus.OK;
    }

    @GetMapping("/calculateRoute")
    @ResponseBody
    public ResponseEntity<GetRouteResponse> calculateRoute(@RequestBody CalculateRouteRequest routeRequest) {
        return ResponseEntity.ok(planeFacade.getRoute(routeRequest.getPlaneId(), routeRequest.getWayPoints()));
    }

    @GetMapping("/flights/{planeId}")
    public ResponseEntity<GetFlightsResponse> getAirplaneFlights(@PathVariable Long planeId) {
        return ResponseEntity.ok(planeFacade.getFlights(planeId));
    }
}
