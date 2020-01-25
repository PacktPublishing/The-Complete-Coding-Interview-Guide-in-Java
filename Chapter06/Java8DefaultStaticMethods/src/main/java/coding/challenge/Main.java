package coding.challenge;

public class Main {

    public static void main(String[] args) {

        Vehicle.description();

        PetrolCar pc = new PetrolCar("Audi", 150);
        System.out.println("Petrol car consume: "
                + String.format("%.1f", pc.computeConsumption(250, 50, pc.getHorsePower()))
                + " l/100km");

        ElectricCar ec = new ElectricCar("Audi", 150);
        System.out.println("Electric car consume: "
                + String.format("%.1f", ec.computeConsumption(250, 50, ec.getHorsePower()))
                + " kW/h");
    }
}
