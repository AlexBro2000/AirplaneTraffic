package com.example.airplanetraffic.facade.factory.response.route;

import com.example.airplanetraffic.facade.dto.response.GetRouteResponse;
import com.example.airplanetraffic.model.entity.TemporaryPoint;

import java.util.List;

public interface GetRouteResponseFactory {

    GetRouteResponse setUpGetRouteResponse(List<TemporaryPoint> temporaryPoints);
}
