package org.v1;

public class Client {
    public static void main(String[] args) {
        Location location1 = new Location(37.7749, -122.4194);
        Location location2 = new Location(37.7749, -122.4194);
        Location location3 = new Location(37.7749, -122.4194);

        Driver driver1 = new Driver("John Doe", new Vehicle("ABC123", "car"), location1);
        driver1.setLocation(location1);

        Driver driver2 = new Driver("Jane Smith", new Vehicle("XYZ789", "bus"), location2);
        driver2.setLocation(location2);

        Passenger passenger1 = new Passenger("Bob Brown", location3);
        Passenger passenger2 = new Passenger("Jane Smith", location3);

        RideSharingAppService app =  new RideSharingAppService();
        app.addDriver(driver1);
        app.addDriver(driver2);
        app.addPassenger(passenger1);
        app.addPassenger(passenger2);

        app.bookRide(passenger1, 10);
        app.bookRide(passenger2, 1100);
    }
}
