package coding.challenge;

public class Main {

    public static void main(String[] args) {

        Programmer p = new Programmer("Joana Nimar", "Toronto");
        
        String name = p.getName();
        String team = p.getTeam();
        
        System.out.println(name + " is assigned to the " + team + " team");
    }

}
