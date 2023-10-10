package com.example.airplanetraffic.model.service.math;

import com.example.airplanetraffic.model.entity.TemporaryPoint;
import com.example.airplanetraffic.model.entity.WayPoint;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultFlightMathService implements FlightMathService {
    @Override
    public List<TemporaryPoint> calculateFlightRoute(WayPoint startPoint, WayPoint endPoint) {
        List<TemporaryPoint> flightRoute = new ArrayList<>();

        double totalTime = calculateTime(startPoint, endPoint);

        for (double currentTime = 0; currentTime <= totalTime; currentTime += 1.0) {
            double fraction = currentTime / totalTime;
            TemporaryPoint interpolatedPoint = interpolatePoint(startPoint, endPoint, fraction);
            flightRoute.add(interpolatedPoint);
        }

        return flightRoute;
    }

    private double calculateTime(WayPoint startPoint, WayPoint endPoint) {
        double latitudeDifference = endPoint.getLatitude() - startPoint.getLatitude();
        double longitudeDifference = endPoint.getLongitude() - startPoint.getLongitude();
        double altitudeDifference = endPoint.getFlightAltitude() - startPoint.getFlightAltitude();
        double speedDifference = endPoint.getFlightSpeed() - startPoint.getFlightSpeed();

        // Calculate the total distance traveled using the Pythagorean theorem
        double distance = Math.sqrt(
                Math.pow(latitudeDifference, 2) +
                        Math.pow(longitudeDifference, 2) +
                        Math.pow(altitudeDifference, 2)
        );

        if (speedDifference == 0) {
            return distance / Math.abs(endPoint.getFlightSpeed());
        }
        return distance / Math.abs(speedDifference);

    }

    private TemporaryPoint interpolatePoint(WayPoint startPoint, WayPoint endPoint, double fraction) {

        TemporaryPoint interpolatedPoint = new TemporaryPoint();
        interpolatedPoint.setLatitude(interpolate(startPoint.getLatitude(), endPoint.getLatitude(), fraction));
        interpolatedPoint.setLongitude(interpolate(startPoint.getLongitude(), endPoint.getLongitude(), fraction));
        interpolatedPoint.setFlightAltitude(interpolate(startPoint.getFlightAltitude(), endPoint.getFlightAltitude(), fraction));
        interpolatedPoint.setFlightSpeed(interpolate(startPoint.getFlightSpeed(), endPoint.getFlightSpeed(), fraction));
        interpolatedPoint.setCourse(calculateCourse(startPoint, endPoint));

        return interpolatedPoint;
    }

    private Long interpolate(Long start, Long end, double fraction) {
        return Math.round(start + fraction * (end - start));
    }

    double calculateCourse(WayPoint startPoint, WayPoint endPoint) {
        double deltaLongitude = Math.toRadians(endPoint.getLongitude() - startPoint.getLongitude());
        double deltaLatitude = Math.toRadians(endPoint.getLatitude() - startPoint.getLatitude());

        // Calculate the course in radians
        double courseRadians = Math.atan2(deltaLongitude, deltaLatitude);

        // Convert radians to gradian (1 gradian = 180/π radians)
        return Math.toDegrees(courseRadians) * 10 / 9;
    }
}
