package com.example.airplanetraffic.facade.validation.waypoint;

import com.example.airplanetraffic.facade.dto.request.data.WayPointData;
import com.example.airplanetraffic.facade.exception.CommonException;
import com.example.airplanetraffic.facade.validation.AbstractFieldValidator;
import com.example.airplanetraffic.model.entity.AirplaneCharacteristic;
import org.springframework.stereotype.Component;

@Component
public class DefaultWayPointDataValidator extends AbstractFieldValidator<WayPointData> implements WayPointDataValidator {

    @Override
    public void validate(WayPointData wayPointData, AirplaneCharacteristic characteristic) {
        super.validate(wayPointData);

        if (characteristic.getMaxSpeed() < wayPointData.getFlightSpeed()) {
            throw new CommonException("Flight speed cannot be more than max speed, " + "max speed" +
                    " for specific airplane is " + characteristic.getMaxSpeed());
        }
    }
}
