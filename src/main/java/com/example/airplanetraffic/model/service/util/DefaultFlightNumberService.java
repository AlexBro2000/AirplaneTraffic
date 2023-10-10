package com.example.airplanetraffic.model.service.util;

import com.example.airplanetraffic.model.entity.FlightSequence;
import jakarta.annotation.Resource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class DefaultFlightNumberService implements FlightNumberService {

    @Resource
    private MongoOperations mongoOperations;

    @Override
    public Long generateFlightNumber() {
        Query query = new Query(Criteria.where("id").is("flight_sequence"));
        Update update = new Update().inc("sequence", 1);

        FlightSequence sequence = mongoOperations.findAndModify(
                query, update, FlightSequence.class
        );

        if (sequence == null) {
            sequence = new FlightSequence();
            sequence.setId("flight_sequence");
            sequence.setSequence(1L);
            mongoOperations.save(sequence);
        }

        return sequence.getSequence();
    }
}
