package srm626.division2;

/**
 * Level 2 Problem
 * 
 * @author emmanuel
 * 
 */
public class FixedDiceGameDiv2 {
  public static double getExpectation(int a, int b) {
    int count = 0;
    double sum = 0;
    for (int bVal = 1; bVal <= b; bVal++) {
      for (int aVal = bVal + 1; aVal <= a; aVal++) {
        sum += aVal;
        count++;
      }
    }
    return sum / count;
  }

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    getExpectation(1000, 1000);
    System.out.println(System.currentTimeMillis() - start);
  }

}
