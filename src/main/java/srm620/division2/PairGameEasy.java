package srm620.division2;

/**
 * Level 2 problem.
 * @author emmanuel
 *
 */
public class PairGameEasy {
  public String able(int a, int b, int c, int d) {
    if (ableUtil(a, b, c, d))
      return "Able to generate";
    else
      return "Not able to generate";
  }

  private boolean ableUtil(int a, int b, int c, int d) {
    if (a == c && b == d)
      return true;
    else if (a > c || b > d)
      return false;
    else {
      return ableUtil(a + b, b, c, d) || ableUtil(a, a+b, c, d);
    }
  }
}
