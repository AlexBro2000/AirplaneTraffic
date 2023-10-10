package com.example.airplanetraffic.model.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "flights")
public class Flight {

    @NotNull
    private Long number;
    private List<WayPoint> wayPoints;
    private List<TemporaryPoint> passedPoints;
}
