package coding.challenge;

public class Main {

    public static void main(String[] args) {

        Hanoi hanoi = new Hanoi();
        
        int n = 3;  // Number of disks 
        
        // A - origin-rod
        // B - intermediate-rod
        // C - target-rod
        hanoi.moveDisks(n, 'A', 'C', 'B');  
    }

}
