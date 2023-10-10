package com.example.airplanetraffic.facade.factory.response.data.temporarypoint;

import com.example.airplanetraffic.facade.dto.response.data.temporarypoint.TemporaryPointData;
import org.springframework.stereotype.Component;

@Component
public class DefaultTemporaryPointDataDataFactory implements TemporaryPointDataFactory {
    @Override
    public TemporaryPointData setUpTemporaryPointData(Long latitude, Long longitude, Long flightAltitude, Long flightSpeed,
                                                      Double course) {
        TemporaryPointData temporaryPoint = new TemporaryPointData();
        temporaryPoint.setLatitude(latitude);
        temporaryPoint.setLongitude(longitude);
        temporaryPoint.setFlightAltitude(flightAltitude);
        temporaryPoint.setFlightSpeed(flightSpeed);
        temporaryPoint.setCourse(course);
        return temporaryPoint;
    }
}
