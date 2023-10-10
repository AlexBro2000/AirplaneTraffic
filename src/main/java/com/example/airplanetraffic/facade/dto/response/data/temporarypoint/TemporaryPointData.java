package com.example.airplanetraffic.facade.dto.response.data.temporarypoint;

import lombok.Data;

@Data
public class TemporaryPointData {

    private Long latitude;
    private Long longitude;
    private Long flightAltitude;
    private Long flightSpeed;
    private Double course;
}
