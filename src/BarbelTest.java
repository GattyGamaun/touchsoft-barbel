import static org.junit.Assert.*;


public class BarbelTest {

  @org.junit.Test
  public void getMaxWeight_0() {
    int[] initWeights = {1,2,3,4,5,6};
    Barbel barbel = new Barbel(initWeights);
    assertEquals(20, barbel.getMaxWeight());
  }

  @org.junit.Test
  public void getMaxWeight_1() {
    int[] initWeights = {1,2,3,6};
    Barbel barbel = new Barbel(initWeights);
    assertEquals(12, barbel.getMaxWeight());
  }

  @org.junit.Test
  public void getMaxWeight_2() {
    int[] initWeights = {1,2};
    Barbel barbel = new Barbel(initWeights);
    assertEquals(0, barbel.getMaxWeight());
  }

  @org.junit.Test
  public void getMaxWeight_3() {
    int[] initWeights = {3,2,3,4,3,6};
    Barbel barbel = new Barbel(initWeights);
    assertEquals(0, barbel.getMaxWeight());
  }

  @org.junit.Test
  public void getMaxWeight_4() {
    int[] initWeights = {2,3,4,12,2};
    Barbel barbel = new Barbel(initWeights);
    assertEquals(0, barbel.getMaxWeight());
  }

  @org.junit.Test
  public void getMaxWeight_5() {
    int[] initWeights = {1,2,4,8,16};
    Barbel barbel = new Barbel(initWeights);
    assertEquals(0, barbel.getMaxWeight());
  }

  @org.junit.Test
  public void getMaxWeight_6() {
    int[] initWeights = {1,4,3,18,3,3};
    Barbel barbel = new Barbel(initWeights);
    assertEquals(0, barbel.getMaxWeight());
  }

  @org.junit.Test
  public void getMaxWeight_7() {
    int[] initWeights = {1,2,4,8,16};
    Barbel barbel = new Barbel(initWeights);
    assertEquals(0, barbel.getMaxWeight());
  }

  @org.junit.Test
  public void getMaxWeight_8() {
    int[] initWeights = {1,4,3,3,18,3,3 };
    Barbel barbel = new Barbel(initWeights);
    assertEquals(0, barbel.getMaxWeight());
  }

}
