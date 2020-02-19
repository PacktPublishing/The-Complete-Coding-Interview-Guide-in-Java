package coding.challenge;

public class Main {

    public static void main(String[] args) {       
        
        int n = 3;  // Number of disks 
        
        // A - origin-rod
        // B - intermediate-rod
        // C - target-rod
        Hanoi.moveDisks(n, 'A', 'C', 'B');  
    }

}
