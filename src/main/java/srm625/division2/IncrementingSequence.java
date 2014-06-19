package srm625.division2;

import java.util.Arrays;

/**
 * Level 2 Problem.
 * 
 * @author emmanuel
 * 
 */
public class IncrementingSequence {
  public String canItBeDone(int k, int[] A) {
    Arrays.sort(A);
    int j;
    for (int i = 0; i < A.length;) {
      j = i + 1;
      if (A[i] == j) {
        i++;
        continue;
      } else if (A[i] > j) {
        return "IMPOSSIBLE";
      } else {
        if ((j - A[i]) % k == 0) {
          A[i] = j;
          i++;
          continue;
        }
        boolean found = false;
        for (int p = i + 1; p < A.length; p++) {
          if (A[p] <= j && ((j - A[p]) % k == 0)) {
            A[p] = A[i];
            A[i] = j;
            Arrays.sort(A, i + 1, A.length);
            found = true;
            i++;
            break;
          }
        }
        if (!found)
          return "IMPOSSIBLE";
      }
    }
    return "POSSIBLE";
  }

  public static void main(String[] args) {
    IncrementingSequence obj = new IncrementingSequence();
    System.out.println(obj.canItBeDone(3, new int[] {1,2,4,3}));
    System.out.println(obj.canItBeDone(5, new int[] {2,2}));
    System.out.println(obj.canItBeDone(1, new int[] {1,1,1,1,1,1,1,1}));
    System.out.println(obj.canItBeDone(2, new int[] {5,3,3,2,1}));
    System.out.println(obj.canItBeDone(9, new int[] {1,2,3,1,4,5,6,7,9,8}));
    System.out.println(obj.canItBeDone(2, new int[] {1,1,1,1,1,1,2,2,2,2,2,2}));
    System.out.println(obj.canItBeDone(1, new int[] {1}));
  }
}
