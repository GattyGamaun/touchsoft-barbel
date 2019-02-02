import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

class Barbel {
  private int[] plates;

  Barbel(int[] plates) {
    for (int i = 0; i < plates.length; i++) {
      if (plates[i] > 0 && plates[i] < 21) {
        if (plates.length < 1000) {
          Arrays.sort(plates);
          this.plates = plates;
        } else throw new Error("Choose quantity of plates from 2 to 1000");
      } else throw new Error("Choose max plate weight from 1 to 20");
    }
  }

  int getMaxWeight() {
    int maxBarbelWeight = 0;
    for (int i : plates) {
      maxBarbelWeight += i;
    }
    if (maxBarbelWeight > 10000) {
      throw new Error("You can not take this weight");
    } else if (maxBarbelWeight % 2 != 0) {
//    else {
      int extraPlate = 0;
      int j = 0;
      while (extraPlate == 0) {
        if (plates[j] % 2 != 0) {
          extraPlate = plates[j];
          plates = ArrayUtils.removeElement(plates, plates[j]);
          maxBarbelWeight = maxBarbelWeight - extraPlate;
//          System.out.println("---------------------------------------" +
//              "\nYou can not use this plate of " + extraPlate + " pound/s " +
//              "\nif you want to save balance\n---------------------------");
        }
        j++;
      }
      int leftSum = 0;
      int n = plates.length;
      int rightSum = 0;

      for (int i = n - 1; i >= 0; i--) {
        // add current element to right_sum
        rightSum += plates[i];

        // exclude current element to the left_sum
        leftSum -= plates[i];
        if (rightSum != leftSum )
          return 0;
      }
      System.out.println(rightSum);
    }


    // if it is not possible to split array
    // into two parts.
    return maxBarbelWeight;

  }
//    return maxBarbelWeight;
//  }

//  void printTwoParts(int arr[], int n)
//    {
//      int splitPoint = findSplitPoint();
//
//      if (splitPoint == -1 || splitPoint == n )
//      {
//        System.out.println("Not Possible" );
//        return;
//      }
//      for (int i = 0; i < n; i++)
//      {
//        if(splitPoint == i)
//          System.out.println();
//
//        System.out.print(arr[i] + " ");
//      }
//  }


  int[] getPlates() {
    return plates;
  }
}
