package org.v1;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RideSharingAppService {
    private List<Driver> drivers = new ArrayList<Driver>();
    private List<Passenger> passengers = new ArrayList<>();

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void bookRide(Passenger passenger, double distance) {
        if(drivers.isEmpty()) {
            System.out.println("No drivers available.");
            return;
        }
        Driver assignedDriver = null;
        double minDistance = Double.MAX_VALUE;
        for (Driver driver : drivers) {
            double currentDriverdistance = calculateDistance(passenger.getLocation(), driver.getLocation());
            if(currentDriverdistance < minDistance) {
                minDistance = currentDriverdistance;
                assignedDriver = driver;
            }
        }

        double expectedFare = calcFare(assignedDriver.getVehicle(), distance);
        System.out.println("Assigned Driver: " + assignedDriver.getName() + ", Expected Fare: " + expectedFare);
        System.out.println("Driver " + assignedDriver.getName() + " is on the way to pick up " + passenger.getName());
    }

    private double calcFare(Vehicle vehicle, double distance) {
        if(vehicle.getType().equalsIgnoreCase("Bus")) {
            return distance * 1.5;
        } else if(vehicle.getType().equalsIgnoreCase("Car")) {
            return distance * 2.0;
        }
        return distance * 2.5; // Default fare for other vehicle types
    }

    private double calculateDistance(Location start, Location end) {
        double dx = start.getLatitude() - end.getLatitude();
        double dy = start.getLongitude() - end.getLongitude();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
