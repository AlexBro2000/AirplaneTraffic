package com.example.airplanetraffic.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "flight_sequence")
@Data
public class FlightSequence {

    @Id
    private String id;
    private Long sequence;
}

