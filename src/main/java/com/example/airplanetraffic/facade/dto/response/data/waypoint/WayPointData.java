package com.example.airplanetraffic.facade.dto.response.data.waypoint;

import lombok.Data;

@Data
public class WayPointData {
    private Long latitude;
    private Long longitude;
    private Long flightAltitude;
    private Long flightSpeed;
}
