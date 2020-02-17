package coding.challenge;

public class Main {
   
    public static void main(String[] args) {

        Converter converter = new Converter();

        System.out.println(Integer.toBinaryString(converter.DoubleToBinary32(-404.0324f)));
   //     
      System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(-404.0324f)));
     // System.out.println("Qqq="+Long.toBinaryString(Double.doubleToRawLongBits(0.72d)));
        
    }

}
