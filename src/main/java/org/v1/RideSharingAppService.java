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
            double currentDriverdistance = calculateDistance(passenger.location, driver.location);
            if(currentDriverdistance < minDistance) {
                minDistance = currentDriverdistance;
                assignedDriver = driver;
            }
        }

        double expectedFare = calcFare(assignedDriver.vehicle, distance);
        System.out.println("Assigned Driver: " + assignedDriver.name + ", Expected Fare: " + expectedFare);
        System.out.println("Driver " + assignedDriver.name + " is on the way to pick up " + passenger.name);
    }

    private double calcFare(Vehicle vehicle, double distance) {


    }

    private double calculateDistance(Location start, Location end) {
        double dx = start
    }
}
