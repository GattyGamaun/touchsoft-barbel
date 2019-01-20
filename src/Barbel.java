import java.util.Arrays;
import java.util.Random;

public class Barbel {
  private int[] plates;
  private int maxPlateWeight;
  private int maxBarbelWeight;
  private int quantityPlates;

  void initializeArray(int maxPlateWeight, int quantityPlates) {
    if (maxPlateWeight > 0 && maxPlateWeight < 21) {
      this.maxPlateWeight = maxPlateWeight;
      if (quantityPlates > 1 && quantityPlates <= 1000) {
        this.quantityPlates = quantityPlates;
        plates = new int[this.quantityPlates];
        for (int i = 0; i < plates.length; i++) {
          int weight = getRandomNumber();
          plates[i] = weight;
        }
      } else throw new Error("Choose quantity of plates from 2 to 1000");
    } else throw new Error("Choose max plate weight from 1 to 20");
  }

  int getMaxBarbelWeight() {
    maxBarbelWeight = 0;
    for (int i : plates) {
      maxBarbelWeight += i;
    }
    return maxBarbelWeight;
  }

  private int getRandomNumber() {
    Random random = new Random();
    return 1 + random.nextInt(maxPlateWeight);
  }

  int[] correctWeight() {
    if (maxBarbelWeight % 2 != 0) {
      Arrays.sort(plates);
      maxBarbelWeight = 0;
      for (int i = 0; i < plates.length; i++) {
        if(plates[i] % 2 != 0) {
          plates[i] = 0;
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
