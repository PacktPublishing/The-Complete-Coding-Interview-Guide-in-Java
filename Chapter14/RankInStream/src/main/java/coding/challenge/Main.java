package coding.challenge;

public class Main {

    public static void main(String[] args) {

      /*        
              40
            /    \
          30      45
         /  \    /  \
        15  33  42  56
       / \       \    \    
      5  17       43  67        
      */
        Stream stream = new Stream();

        stream.generate(40);
        stream.generate(30);
        stream.generate(45);
        stream.generate(15);
        stream.generate(33);
        stream.generate(42);
        stream.generate(56);
        stream.generate(5);
        stream.generate(17);
        stream.generate(43);
        stream.generate(67);

        System.out.println("Rank of 40: " + stream.getRank(40));
        System.out.println("Rank of 30: " + stream.getRank(30));
        System.out.println("Rank of 45: " + stream.getRank(45));
        System.out.println("Rank of 15: " + stream.getRank(15));
        System.out.println("Rank of 33: " + stream.getRank(33));
        System.out.println("Rank of 42: " + stream.getRank(42));
        System.out.println("Rank of 56: " + stream.getRank(56));
        System.out.println("Rank of 5: " + stream.getRank(5));
        System.out.println("Rank of 17: " + stream.getRank(17));
        System.out.println("Rank of 43: " + stream.getRank(43));
        System.out.println("Rank of 67: " + stream.getRank(67));
        System.out.println("Rank of 6: " + stream.getRank(6));
    }
}
