package com.example.airplanetraffic.facade.factory.response.route;

import com.example.airplanetraffic.facade.dto.response.GetRouteResponse;
import com.example.airplanetraffic.facade.factory.response.data.temporarypoint.TemporaryPointDataFactory;
import com.example.airplanetraffic.model.entity.TemporaryPoint;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultGetRouteResponseFactory implements GetRouteResponseFactory {

    @Resource
    private TemporaryPointDataFactory temporaryPointDataFactory;

    @Override
    public GetRouteResponse setUpGetRouteResponse(List<TemporaryPoint> temporaryPoints) {
        GetRouteResponse response = new GetRouteResponse();
        response.setTemporaryPoints(temporaryPoints
                .stream()
                .map(temporaryPoint -> temporaryPointDataFactory.setUpTemporaryPointData(temporaryPoint.getLatitude(),
                        temporaryPoint.getLongitude(), temporaryPoint.getFlightAltitude(), temporaryPoint.getFlightSpeed(),
                        temporaryPoint.getCourse())).toList());
        response.setFlyingTime(temporaryPoints.size() + " seconds");
        return response;
    }
}
