package coding.challenge.vehicle;

public class Van extends Vehicle {       
    
    public Van(String licensePlate) {
        super(licensePlate, VehicleType.VAN.getSpotsNeeded(), VehicleType.VAN);
    }        
}
