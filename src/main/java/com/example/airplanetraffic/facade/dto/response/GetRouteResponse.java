package com.example.airplanetraffic.facade.dto.response;

import com.example.airplanetraffic.facade.dto.response.data.temporarypoint.TemporaryPointData;
import lombok.Data;

import java.time.Duration;
import java.util.List;

@Data
public class GetRouteResponse {

    private List<TemporaryPointData> temporaryPoints;
    private Duration flyingTime;


    @Override
    public String toString() {
        return "GetRouteResponse{" +
                "temporaryPoints=" + temporaryPoints +
                ", flyingTime=" + flyingTime.getSeconds() + "s" +
                '}';
    }
}
