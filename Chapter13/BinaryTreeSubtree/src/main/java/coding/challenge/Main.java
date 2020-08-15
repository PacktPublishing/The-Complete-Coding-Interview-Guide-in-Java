package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        /*    P:                     Q:   
              40                     30
            /    \                  /  \ 
          30      10               20   90 
         /  \    /  \             /
        20   90  70 80           6
       /
      6  
        */
        BinaryTree<Integer> p = new BinaryTree<>();

        p.insert(40);
        p.insert(30);
        p.insert(10);
        p.insert(20);
        p.insert(90);
        p.insert(70);
        p.insert(80);
        p.insert(6);
        
        BinaryTree<Integer> q = new BinaryTree<>();

        q.insert(30);
        q.insert(20);
        q.insert(90);
        q.insert(6);
        
        System.out.println("'p' subtree of 'q' ? " + p.isSubtree(q));
        System.out.println("'q' subtree of 'p' ? " + q.isSubtree(p));
    }
}
