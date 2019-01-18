import java.util.Arrays;

public class Main {
  public static void main(String[] args) {

    //Make instance of class
    Barbel barbel = new Barbel();

    //Initialize array of plates;
    //Set max weight of the plate and the quantity
    barbel.initializeArray(20, 10);

    //Print max weight of the barbel
    System.out.println("The max barbel weight is " + barbel.getMaxBarbelWeight());

    //Print array of plates
    int[] plates = barbel.getPlates();
    System.out.println("Plates: " + Arrays.toString(plates));

    //Correct weight
    int[] correctedPlates = barbel.correctWeight();
    System.out.println("Corrected Plates: " + Arrays.toString(correctedPlates));

    //Print corrected max weight of the barbel
    System.out.println("The corrected max barbel weight is " + barbel.getMaxBarbelWeight());

  }
}
