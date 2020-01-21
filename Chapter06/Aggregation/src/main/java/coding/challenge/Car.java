package coding.challenge;

public class Car {
    
    private String name;
    private Gearbox gearbox;

    public Car(String name, Gearbox gearbox) {
        this.name = name;
        this.gearbox = gearbox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }                  
}
