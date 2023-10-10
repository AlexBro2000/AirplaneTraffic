package com.example.airplanetraffic.model.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "airplanes")
public class Airplane {

    @Id
    @NotNull
    private Long planeId;
    @NotNull
    private AirplaneCharacteristic airplaneCharacteristic;
    @NotNull
    private TemporaryPoint position;
    @NotNull
    private List<Flight> flights;

}
