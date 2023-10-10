package com.example.airplanetraffic.model.service.airplane;

import com.example.airplanetraffic.model.entity.Airplane;

import java.util.Optional;

public interface AirplaneService {

    Optional<Airplane> findByPlaneId(Long id);

    void save(Airplane airplane);
}
