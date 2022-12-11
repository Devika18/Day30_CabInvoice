package org.example;

public class InvoiceService {
    private static final double COST_PER_KM = 10;
    private static final double COST_PER_MIN = 1;
    private static final double MIN_Fare = 5;

    public double calculateFare(double distance, int time) {

        double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;
        return Math.max(totalFare, MIN_Fare);
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides){
            totalFare += this.calculateFare(ride.distance,ride.time);
        }
        return totalFare;
    }
}
