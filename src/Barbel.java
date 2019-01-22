import java.util.Arrays;

class Barbel {
  private int[] plates;
  private int maxBarbelWeight;

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
    maxBarbelWeight = 0;
    for (int i : this.plates) {
      maxBarbelWeight += i;
      }
    if (maxBarbelWeight > 10000) {
      throw new Error("You can not take this weight");
    } else {
      return maxBarbelWeight;
    }
  }

  int[] correctWeight() {
    int extraPlate;
    if (maxBarbelWeight % 2 != 0) {
      Arrays.sort(plates);
      maxBarbelWeight = 0;
      for (int i = 0; i < plates.length; i++) {
        if(plates[i] % 2 != 0) {
          extraPlate = plates[i];
          plates[i] = 0;
          System.out.println("You can not use this plate of " + extraPlate + " pound/s if " +
              "\nyou want to save balance");
        }
        break;
      }
      return plates;
    } else {
      return plates;
    }
  }

  int[] getPlates() {
    return plates;
  }
}
