package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable();

        // Put some key-value
        hashTable.put("ana", "ana".toUpperCase());
        hashTable.put("carina", "carina".toUpperCase());
        hashTable.put("barbu", "barbu".toUpperCase());
        hashTable.put("leo", "leo".toUpperCase());
        hashTable.put("marius", "marius".toUpperCase());
        hashTable.put(5, "FIVE");
        hashTable.put(10, "TEN");

        // The following keys should exists
        System.out.println("Get(ana): " + hashTable.get("ana"));        
        System.out.println("Get(carina): " + hashTable.get("carina"));
        System.out.println("Get(barbu): " + hashTable.get("barbu"));
        System.out.println("Get(leo): " + hashTable.get("leo"));
        System.out.println("Get(marius): " + hashTable.get("marius"));
        System.out.println("Get(5): " + hashTable.get(5));
        System.out.println("Get(10): " + hashTable.get(10));
        
        // The following two keys should not exists
        System.out.println("Get(anna): " + hashTable.get("anna"));
        System.out.println("Get(15): " + hashTable.get(15));               
    }
}

