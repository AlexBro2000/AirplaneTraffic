package com.example.airplanetraffic.model.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "airplane_characteristics")
public class AirplaneCharacteristic {

    @NotNull
    private Long maxSpeed;
    @NotNull
    private Long maxAcceleration;
    @NotNull
    private Long heightChangesSpeed;
    @NotNull
    private Long flightCourseSpeed;

}
