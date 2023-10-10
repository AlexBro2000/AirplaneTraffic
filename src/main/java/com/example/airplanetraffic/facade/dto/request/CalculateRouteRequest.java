package com.example.airplanetraffic.facade.dto.request;

import com.example.airplanetraffic.facade.dto.request.data.WayPointData;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CalculateRouteRequest {

    @NotNull
    private Long planeId;
    private List<WayPointData> wayPoints;
}
