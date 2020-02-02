package coding.challenge.vehicle;

public class Car extends Vehicle {
        
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR.getSpotsNeeded(), VehicleType.CAR);
    }        
}
