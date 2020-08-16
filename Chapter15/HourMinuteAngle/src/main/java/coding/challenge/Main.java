package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        float clock1 = Clock.findAngle(10, 10);
        float clock2 = Clock.findAngle(9, 40);
        float clock3 = Clock.findAngle(4, 40);
        
        float clock4 = Clock.findAngle(12, 1);
        float clock5 = Clock.findAngle(4, 19);
        
        System.out.println("10:10 has an angle of " + clock1 + " degrees");
        System.out.println("9:40 has an angle of " + clock2 + " degrees");
        System.out.println("4:40 has an angle of " + clock3 + " degrees");        
        System.out.println("12:01 has an angle of " + clock4 + " degrees");        
        System.out.println("4:19 has an angle of " + clock5 + " degrees");        
    }
}
