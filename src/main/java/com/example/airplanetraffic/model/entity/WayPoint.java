package com.example.airplanetraffic.model.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "way_points")
public class WayPoint {

    @NotNull
    private Long latitude;
    @NotNull
    private Long longitude;
    @NotNull
    private Long flightAltitude;
    @NotNull
    private Long flightSpeed;
}
