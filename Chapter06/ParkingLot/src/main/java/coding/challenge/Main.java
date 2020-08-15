package coding.challenge;
 
import coding.challenge.parking.ParkingFloor;
import coding.challenge.parking.ParkingLot;
import coding.challenge.parking.ParkingTicket;
import coding.challenge.parking.VehicleType;
import coding.challenge.parking.system.ParkingSystem;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        
        Map<String, ParkingFloor> floors = new HashMap<>();                        
        floors.put("Aqua", new ParkingFloor("Aqua", 5));
        floors.put("Magenta", new ParkingFloor("Magenta", 5));
        ParkingLot parkingLot = new ParkingLot("SkyParking", floors);
        
        ParkingSystem parkingSystem = new ParkingSystem("1", parkingLot);
        
        // parking a van
        System.out.println("\n\n");
        ParkingTicket parkingTicket1 = parkingSystem.parkVehicleBtn("003-BOSS", VehicleType.VAN);
        ParkingTicket parkingTicket2 = parkingSystem.parkVehicleBtn("123-333", VehicleType.CAR);
        ParkingTicket parkingTicket3 = parkingSystem.parkVehicleBtn("ANCVV", VehicleType.TRUCK);
        ParkingTicket parkingTicket4 = parkingSystem.parkVehicleBtn("ZZZ-099", VehicleType.CAR);
        
        System.out.println("\n\n");
        System.out.println("Parking ticket: " + parkingTicket1);
        System.out.println("Parking ticket: " + parkingTicket2);
        System.out.println("Parking ticket: " + parkingTicket3);
        System.out.println("Parking ticket: " + parkingTicket4);
        
        // drivers un-park their vehicles via ParkingSystem
        System.out.println("\n\n");
        System.out.println("Un-parking done: " + parkingSystem.unparkVehicleBtn(parkingTicket1));
        System.out.println("Un-parking done: " + parkingSystem.unparkVehicleBtn("123-333", VehicleType.CAR));
        System.out.println("Un-parking done: " +parkingSystem.unparkVehicleBtn("ANCVV", VehicleType.TRUCK));
        System.out.println("Un-parking done: " +parkingSystem.unparkVehicleBtn(parkingTicket4));       
    }
}
