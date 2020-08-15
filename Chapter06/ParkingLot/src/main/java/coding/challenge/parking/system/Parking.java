package coding.challenge.parking.system;
 
import coding.challenge.parking.ParkingTicket;
import coding.challenge.parking.VehicleType;

public interface Parking {
    
    public ParkingTicket parkVehicleBtn(String licensePlate, VehicleType type);
    public boolean unparkVehicleBtn(String licensePlate, VehicleType type);
    public boolean unparkVehicleBtn(ParkingTicket parkingTicket);        
}
