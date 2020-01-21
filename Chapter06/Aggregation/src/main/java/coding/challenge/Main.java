package coding.challenge;

public class Main {

    public static void main(String[] args) {

        Gearbox gearbox = new Gearbox("Manual", 6);
        Car car = new Car("BMW", gearbox);
        
        System.out.println("This " + car.getName() 
                + " has " + car.getGearbox().getGears() + " gears");
    }

}
