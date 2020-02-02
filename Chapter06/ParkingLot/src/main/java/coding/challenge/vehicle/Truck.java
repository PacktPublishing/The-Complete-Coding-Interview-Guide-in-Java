package coding.challenge.vehicle;

public class Truck extends Vehicle {
        
    public Truck(String licensePlate) {
        super(licensePlate, VehicleType.TRUCK.getSpotsNeeded(), VehicleType.TRUCK);
    }    
}
