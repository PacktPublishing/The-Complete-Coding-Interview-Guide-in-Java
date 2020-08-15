package coding.challenge;
 
import coding.challenge.filesystem.Directory;
import coding.challenge.filesystem.File;

public class Main {

    public static void main(String[] args) {
        
        /*
        D:/
         |
         ----Docs
         |      |
         |      ----summer.txt
         |      ----winter.txt
         ----Today   
                |
                ----spring.txt 
        */
        
        Directory root = new Directory("D", null);
        Directory docs = new Directory("Docs", root);
        Directory today = new Directory("Today", root);
        
        File doc1 = new File("summer.txt", docs);
        File doc2 = new File("winter.txt", docs);
        File doc3 = new File("spring.txt", today);
        
        doc1.setContent("This is a summer doc");
        doc2.setContent("This is a winter doc done last year");
        doc3.setContent("This is a spring doc done today");
        
        System.out.println("D root full path: " + root.getFullPath());
        System.out.println("Docs directory full path: " + docs.getFullPath());
        System.out.println("doc3.txt file full path: " + doc3.getFullPath());
    }

}
