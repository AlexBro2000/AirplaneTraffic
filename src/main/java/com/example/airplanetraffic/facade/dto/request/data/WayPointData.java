package com.example.airplanetraffic.facade.dto.request.data;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WayPointData {
    @NotNull(message = "Latitude cannot be null!")
    @Min(value = -90, message = "Latitude must be equal to or greater than - 90!")
    @Max(value = 90, message = "Latitude must be equal to or less than 90!")
    private Long latitude;
    @NotNull(message = "Longitude cannot be null")
    @Min(value = -180, message = "Longitude must be equal to or greater than - 180!")
    @Max(value = 180, message = "Longitude must be equal to or less than - 180!")
    private Long longitude;
    @NotNull(message = "Flight altitude cannot be null")
    @Min(value = 0, message = "Flight altitude must be equal to or greater than 0!")
    private Long flightAltitude;
    @NotNull(message = "Flight speed cannot be null")
    @Min(value = 0, message = "Flight speed must be equal to or greater than 0!")
    private Long flightSpeed;
}
