package com.example.airplanetraffic.facade.dto.response.data.flight;

import com.example.airplanetraffic.facade.dto.response.data.temporarypoint.TemporaryPointData;
import com.example.airplanetraffic.facade.dto.response.data.waypoint.WayPointData;
import lombok.Data;

import java.time.Duration;
import java.util.List;

@Data
public class FlightData {

    private Long number;
    private List<TemporaryPointData> passedPoints;
    private List<WayPointData> wayPoints;
    private Duration flyingTime;

    @Override
    public String toString() {
        return "FlightData{" +
                "number=" + number +
                ", passedPoints=" + passedPoints +
                ", wayPoints=" + wayPoints +
                ", flyingTime=" + flyingTime.getSeconds() + "s" +
                '}';
    }
}
