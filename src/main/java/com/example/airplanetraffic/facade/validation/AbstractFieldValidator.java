package com.example.airplanetraffic.facade.validation;

import com.example.airplanetraffic.facade.exception.CommonException;
import jakarta.annotation.Resource;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public abstract class AbstractFieldValidator<T> implements FieldValidator<T> {

    @Resource
    private Validator validator;


    @Override
    public void validate(T request) {
        Set<ConstraintViolation<T>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("Validation errors:\n");
            for (ConstraintViolation<T> violation : violations) {
                errorMessage.append(violation.getPropertyPath()).append(": ").append(violation.getMessage()).append("\n");
            }
            throw new CommonException(errorMessage.toString());
        }
    }
}
