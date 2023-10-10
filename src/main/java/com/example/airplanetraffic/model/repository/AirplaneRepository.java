package com.example.airplanetraffic.model.repository;

import com.example.airplanetraffic.model.entity.Airplane;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AirplaneRepository extends MongoRepository<Airplane, String> {

    Optional<Airplane> findByPlaneId(Long planeId);
}
