import java.util.Arrays;

public class Main {
  public static void main(String[] args) {

    //Initialize array of plates;
    int[] initWeights = {2,3,1,1,10,13,20,3};

    //Make instance of class
    Barbel barbel = new Barbel(initWeights);

    //Calculate max weight
    int maxWeight = barbel.getMaxWeight();

    //Print max weight of the barbel
    System.out.println("The max barbel weight is " + maxWeight);

    //Print array of plates
    int[] plates = barbel.getPlates();
    System.out.println("Plates: " + Arrays.toString(plates));

    //Correct weight
    int[] correctedPlates = barbel.correctWeight();
    System.out.println("Corrected Plates: " + Arrays.toString(correctedPlates));

    //Print corrected max weight of the barbel
    int maxCorrectedWeight = barbel.getMaxWeight();
    System.out.println("The corrected max barbel weight is " + maxCorrectedWeight);

  }
}
