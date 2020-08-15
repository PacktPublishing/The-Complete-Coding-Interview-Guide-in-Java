package coding.challenge.parking;
 
import java.util.Objects;

public class Vehicle {

    private final String licensePlate;
    private final int spotsNeeded;
    private final VehicleType type;
        
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
