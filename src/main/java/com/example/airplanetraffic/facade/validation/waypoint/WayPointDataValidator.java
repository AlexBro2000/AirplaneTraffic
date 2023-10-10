package com.example.airplanetraffic.facade.validation.waypoint;

import com.example.airplanetraffic.facade.dto.request.data.WayPointData;
import com.example.airplanetraffic.model.entity.AirplaneCharacteristic;

public interface WayPointDataValidator {

    void validate(WayPointData wayPointData, AirplaneCharacteristic characteristic);
}
