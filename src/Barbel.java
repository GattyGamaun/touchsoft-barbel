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
    }
    else if (maxBarbelWeight % 2 != 0) {
      int extraPlate = 0;
      int i = 0;
      while (extraPlate == 0) {
        if (plates[i] % 2 != 0) {
          extraPlate = plates[i];
          plates[i] = 0;
          maxBarbelWeight = maxBarbelWeight - extraPlate;
                    System.out.println("---------------------------------------" +
              "\nYou can not use this plate of " + extraPlate + " pound/s " +
              "\nif you want to save balance\n---------------------------");
        }
        i++;
      }
      if (!canBalance(plates)) {
        return 0;
      }
      return maxBarbelWeight;
    } if (maxBarbelWeight - plates[plates.length - 1] != maxBarbelWeight / 2) {
      return 0;
    }
    else {
      return maxBarbelWeight;
    }
  }

  private boolean canBalance(int[] nums) {
    int leftSum = 0, rightSum = 0, i, j;
    if(nums.length == 1)
      return false;
    for(i=0, j=nums.length-1; i<=j ;){
      if(leftSum <= rightSum){
        leftSum+=nums[i];
        i++;
      }else{
        rightSum+=nums[j];
        j--;
      }
    }
    return (rightSum == leftSum);
  }



  int[] getPlates() {
    return plates;
  }
}
