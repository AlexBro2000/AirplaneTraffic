package com.example.airplanetraffic.facade.factory.response.data.temporarypoint;

import com.example.airplanetraffic.facade.dto.response.data.temporarypoint.TemporaryPointData;

public interface TemporaryPointDataFactory {

    TemporaryPointData setUpTemporaryPointData(Long latitude, Long longitude, Long flightAltitude, Long flightSpeed,
                                               Double course);
}
