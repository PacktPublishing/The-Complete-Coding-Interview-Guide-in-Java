package coding.challenge;

public class Main {
 
    public static void main(String[] args) {

        MyMap<String, Integer> map = new MyMap<>();
        
        map.put("Alex", 1);
        map.put("Tomy", 2);
        map.put("Anna", 3); 
        
        System.out.println("Alex value is: " + map.get("Alex"));
        
        map.remove("Alex");

        System.out.println(map);
    }

}
