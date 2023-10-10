package com.example.airplanetraffic.facade.validation.airplane;

import com.example.airplanetraffic.facade.dto.request.AddAirplaneRequest;

public interface AddAirplaneRequestValidator {

    void validate(AddAirplaneRequest request);
}
