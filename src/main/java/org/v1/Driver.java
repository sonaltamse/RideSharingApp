package org.v1;

public class Driver {
    private String name;
    private Vehicle vehicle;
    private Location location;

    public Driver(String name, Vehicle vehicle, Location location) {
        this.name = name;
        this.vehicle = vehicle;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }
}
