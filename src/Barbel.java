import org.apache.commons.lang3.ArrayUtils;

class Barbel {
  private int[] plates;

  Barbel(int[] plates) {
    for (int i = 0; i < plates.length; i++) {
      if (plates[i] > 0 && plates[i] < 21) {
        if (plates.length < 1000) {
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
      int extraPlate = 0;
      int j = 0;
      while (extraPlate == 0) {
        if (plates[j] % 2 != 0) {
          extraPlate = plates[j];
          plates = ArrayUtils.removeElement(plates, plates[j]);
        }
        j++;
      }
    }

    int n = plates.length;
    int rightSum = 0;

    for (int i = n - 1; i >= 0; i--) {

      rightSum += plates[i];
      maxBarbelWeight -= plates[i];

      if (rightSum == maxBarbelWeight) {
        return maxBarbelWeight + rightSum;
      }
    }

    return 0;
  }

  int[] getPlates() {
    return plates;
  }
}
