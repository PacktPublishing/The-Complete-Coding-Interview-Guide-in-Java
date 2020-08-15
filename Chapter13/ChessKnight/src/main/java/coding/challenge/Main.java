package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        ChessKnight ck = new ChessKnight();

        int movesNr = ck.countknightMoves(0, 7, 7, 0, 8);

        System.out.println("Minimum number of needed moves: " + movesNr);
    }
}
