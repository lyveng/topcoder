package srm624.division2;

import java.util.Arrays;

public class CostOfDancing {
  public int minimum(int K, int[] danceCost)
  {
      Arrays.sort(danceCost);
      int sum = 0;
      for (int i=0;i<K;i++)
        sum+=danceCost[i];
      return sum;
  }

  public static void main(String[] args) {
    CostOfDancing obj = new CostOfDancing();
    System.out.println(obj.minimum(2, new int[] {1,5,3,4}));
    System.out.println(obj.minimum(3, new int[] {1,5,4}));
    System.out.println(obj.minimum(1, new int[] {2,2,4,5,3}));
    System.out.println(obj.minimum(39, new int[] {973, 793, 722, 573, 521, 568, 845, 674, 595, 310, 284, 794, 913, 93, 129, 758, 108, 433, 181, 163, 96, 932, 703, 989, 884, 420, 615, 991, 364, 657, 421, 336, 801, 142, 908, 321, 709, 752, 346, 656, 413, 629, 801}));
  }

}
