package com.example.airplanetraffic.model.service.airplane;

import com.example.airplanetraffic.model.entity.Airplane;
import com.example.airplanetraffic.model.repository.AirplaneRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultAirplaneService implements AirplaneService {

    @Resource
    private AirplaneRepository airplaneRepository;

    @Override
    public Optional<Airplane> findByPlaneId(Long id) {
        return airplaneRepository.findByPlaneId(id);
    }

    @Override
    public void save(Airplane airplane) {
        airplaneRepository.save(airplane);
    }
}
