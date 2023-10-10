package com.example.airplanetraffic.facade.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AddAirplaneRequest {

    @NotNull(message = "Plane id cannot be null!")
    private Long planeId;

    @NotNull(message = "Max speed cannot be null!")
    @Min(value = 0, message = "Max speed must be equal to or greater than 0!")
    private Long maxSpeed;

    @NotNull(message = "Max acceleration cannot be null!")
    @Min(value = 0, message = "Max acceleration must be equal to or greater than 0!")
    private Long maxAcceleration;

    @NotNull(message = "Height changes speed cannot be null!")
    @Min(value = 0, message = "The rate of change of height must be equal to or greater than 0!")
    private Long heightChangesSpeed;

    @NotNull(message = "Flight course speed cannot be null!")
    @Min(value = 0, message = "Flight course speed must be equal to or greater than 0!")
    private Long flightCourseSpeed;

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

    @NotNull(message = "Course cannot be null")
    @DecimalMin(value = "0.0", message = "Course must be equal to or greater than 0.0!")
    @DecimalMax(value = "360.0", message = "Course must be equal to or less than 360.0")
    private Double course;
}
