package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache();
        
        cache.putEntry(1, 10);
        cache.putEntry(2, 20);
        cache.putEntry(3, 30);
        cache.putEntry(4, 40);
        cache.putEntry(5, 50);
        cache.putEntry(6, 60);
        cache.putEntry(7, 70);
        
        cache.print();
        
        System.out.println("\nGet key 4: " + cache.getEntry(4));
        
        cache.print();
        
        cache.putEntry(8, 80);
        cache.putEntry(9, 90);
        
        cache.print();
        
        System.out.println("\nGet key 6: " + cache.getEntry(6));        
        cache.print();
        
        System.out.println("\nGet key 2 (-1 means data not found): " + cache.getEntry(2));                
        cache.print();               
        
        System.out.println("\nGet key 6: " + cache.getEntry(6));                
        cache.print();               
        
        System.out.println("\nGet key 8: " + cache.getEntry(8));                
        cache.print();               
        
        cache.putEntry(10, 100);
        cache.print();               
    }
    

}
