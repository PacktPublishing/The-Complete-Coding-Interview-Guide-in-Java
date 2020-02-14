package coding.challenge;

public class Multiply {

    public int multiplyBits(int q, int p) {

        int copyQ = q;
        int copyP = p;

        int result = 0;

        while (copyP != 0) {

            if ((copyP & 01) != 0) {
                result = result + copyQ;
            }

            copyQ = copyQ << 1;
            copyP = copyP >> 1;
        }

        return result;
    }
}
