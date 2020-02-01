package coding.challenge.actor;

import coding.challenge.vehicle.Vehicle;

public class Driver {

    private final String name;
    private final Vehicle vehicle;

    public Driver(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    
}
