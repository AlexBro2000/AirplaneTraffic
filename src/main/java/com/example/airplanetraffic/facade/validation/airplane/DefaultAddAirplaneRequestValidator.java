package com.example.airplanetraffic.facade.validation.airplane;

import com.example.airplanetraffic.facade.dto.request.AddAirplaneRequest;
import com.example.airplanetraffic.facade.exception.CommonException;
import com.example.airplanetraffic.facade.validation.AbstractFieldValidator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultAddAirplaneRequestValidator extends AbstractFieldValidator<AddAirplaneRequest> implements AddAirplaneRequestValidator {

    @Override
    public void validate(AddAirplaneRequest request) {
        super.validate(request);

        List<String> validationErrors = new ArrayList<>();

        validateMaxAcceleration(request, validationErrors);
        validateFlightSpeed(request, validationErrors);

        if (!validationErrors.isEmpty()) {
            throw new CommonException(String.join("\n", validationErrors));
        }
    }

    private void validateMaxAcceleration(AddAirplaneRequest request,
                                         List<String> validationErrors) {
        if (request.getMaxSpeed() < request.getMaxAcceleration()) {
            validationErrors.add("Max acceleration cannot be more than max speed!");
        }
    }

    private void validateFlightSpeed(AddAirplaneRequest request,
                                     List<String> validationErrors) {
        if (request.getMaxSpeed() < request.getFlightSpeed()) {
            validationErrors.add("Flight speed cannot be more than max speed!");
        }
    }
}
