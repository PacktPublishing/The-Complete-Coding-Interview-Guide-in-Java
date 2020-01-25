package coding.challenge;

public class SteamCar implements Vehicle {

    private String name;

    public SteamCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void speedUp() {
        System.out.println("Speed up the steam car ...");
    }

    @Override
    public void slowDown() {
        System.out.println("Slow down the steam car ...");
    }
}
