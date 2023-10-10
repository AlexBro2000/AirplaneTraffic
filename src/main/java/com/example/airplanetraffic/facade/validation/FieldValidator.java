package com.example.airplanetraffic.facade.validation;

public interface FieldValidator<T> {

    void validate(T request);
}
