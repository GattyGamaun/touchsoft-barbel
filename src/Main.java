import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {

    //Initialize array of plates;
//    int[] initWeights = {1,4,3,18,3,3};//0
//    int[] initWeights = {1,4,3,3,18,3,3};//0
//    int[] initWeights = {1,2,3,6};//12
//    int[] initWeights = {1,2};//0
//    int[] initWeights = {1,2,3,4,5,6};//0
    int[] initWeights = {3,2,3,4,3,6};//0
//    int[] initWeights = {2,3,4,12,2};//0
//    int[] initWeights = {1,2,4,8,16};//0

    //Make instance of class
    Barbel barbel = new Barbel(initWeights);

    //Print array of plates
    int[] plates = barbel.getPlates();
    System.out.println("Input: " + Arrays.toString(plates));

    //Print corrected max weight of the barbel
    int maxCorrectedWeight = barbel.getMaxWeight();
    System.out.println("The max barbel weight is " + maxCorrectedWeight);

  }
}
