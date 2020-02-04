package coding.challenge.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vehicle {

    private final String licensePlate;
    private final int spotsNeeded;
    private final VehicleType type;
    
    private String parkingFloorName;
    private List<String> parkingSpotsLabels = new ArrayList<>();

    public Vehicle(String licensePlate, int spotsNeeded, VehicleType type) {
        this.licensePlate = licensePlate;
        this.spotsNeeded = spotsNeeded;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleType getType() {
        return type;
    }

    public String getParkingFloorName() {
        return parkingFloorName;
    }    

    public List<String> getParkingSpotsLabels() {
        return parkingSpotsLabels;
    }
    
    protected void setParkingFloorName(String parkingFloorName) {
        this.parkingFloorName = parkingFloorName;
    }

    protected void setParkingSpotsLabels(List<String> parkingSpotsLabels) {
        this.parkingSpotsLabels = parkingSpotsLabels;
    }
        
    @Override
    public String toString() {
        return "Vehicle{" + "licensePlate=" + licensePlate 
                + ", spotsNeeded=" + spotsNeeded + ", type=" + type + '}';
    }        

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.licensePlate);
        hash = 89 * hash + this.spotsNeeded;
        hash = 89 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Vehicle other = (Vehicle) obj;
        if (this.spotsNeeded != other.spotsNeeded) {
            return false;
        }
        
        if (!Objects.equals(this.licensePlate, other.licensePlate)) {
            return false;
        }
        
        if (this.type != other.type) {
            return false;
        }
        
        return true;
    }
    
    
}
