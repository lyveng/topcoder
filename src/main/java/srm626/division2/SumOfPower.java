package srm626.division2;

/**
 * Level 1 problem.
 * 
 * @author emmanuel
 * 
 */
public class SumOfPower {
  public int findSum(int[] array) {
    int ret = 0, curSum = 0;
    for (int i = 0; i < array.length; i++) {
      for (int subLength = 1; subLength <= (array.length - i); subLength++) {
        curSum = 0;
        for (int j = i; j < i + subLength; j++)
          curSum += array[j];
        ret += curSum;
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    SumOfPower obj = new SumOfPower();
    System.out.println(obj.findSum(new int[] {19}));
  }

}
