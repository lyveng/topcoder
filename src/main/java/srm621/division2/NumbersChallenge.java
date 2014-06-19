package srm621.division2;

import java.util.BitSet;

/**
 * Level 2 problem
 * @author emmanuel
 *
 */
public class NumbersChallenge {
  public int minNumber(int[] S) {
    BitSet sumPossible = new BitSet();
    int maxSum = 100000*20 + 1;
    int sum;
    for (int i=1;i<(1<<S.length);i++) {
      sum = 0;
      for (int j=0;j<S.length;j++) {
        if (((1<<j) & i) != 0)
          sum+= S[j];
      }
      sumPossible.set(sum);
    }
    for (int i=1;i<maxSum;i++)
      if (!sumPossible.get(i))
        return i;
    return maxSum;
  }

  public static void main(String[] args) {
    NumbersChallenge obj = new NumbersChallenge();
    System.out.println(obj.minNumber(new int[] {5,1,2}));
    System.out.println(obj.minNumber(new int[] {2,1,4}));
    System.out.println(obj.minNumber(new int[] {2,1,2,7}));
    System.out.println(obj.minNumber(new int[] {94512, 2, 87654, 81316, 6, 5, 6, 37151, 6, 139, 1, 36, 307, 1, 377, 101, 8, 37, 58, 1}));
    System.out.println(obj.minNumber(new int[] {883, 66392, 3531, 28257, 1, 14131, 57, 1, 25, 88474, 4, 1, 110, 6, 1769, 220, 442, 7064, 7, 13}));
  }

}
