package coding.challenge;

import coding.challenge.actor.Driver;
import coding.challenge.actor.ParkingSystem;
import coding.challenge.parking.ParkingFloor;
import coding.challenge.parking.ParkingLot;
import coding.challenge.vehicle.Van;
import coding.challenge.vehicle.Vehicle;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Vehicle van = new Van("4592-EE");
        Driver driverVan = new Driver("Mark Jabel", van);

        ParkingFloor aqua = new ParkingFloor("Aqua", 25);
        ParkingFloor magenta = new ParkingFloor("Magenta", 35);
        ParkingLot parkingLot = new ParkingLot("SkyParking", List.of(aqua, magenta));
        
        ParkingSystem parkingSystem = new ParkingSystem("1", parkingLot);
        
        // driverTruck at ParkingSystem
        String parkingSpotLabels = parkingSystem.parkCar(van);
        
        System.out.println("Parking spots: " + parkingSpotLabels);
    }
}
