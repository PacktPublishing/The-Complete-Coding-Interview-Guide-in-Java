package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int k = 3;
        int floors[] = {4, 2, 1, 2, 4};
        
        System.out.println("Minimum time: " + Elevators.time(k, floors));
    }
}
