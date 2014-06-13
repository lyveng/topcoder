package srm624.round1.division2;

import java.util.Arrays;

public class BuildingHeightsEasy {
  public int minimum(int M, int[] heights) {
    if (M==1)
      return 0;
    Arrays.sort(heights);
    int minSum = Integer.MAX_VALUE;
    for (int i=0;(i+M-1)<heights.length;i++) {
      int sum = 0, last=heights[i+M-1];
      for (int j=i;j<(i+M-1);j++)
        sum += (last-heights[j]);
      if (sum < minSum)
        minSum = sum;
    }
    return minSum;
  }

  public static void main(String[] args) {
    BuildingHeightsEasy obj = new BuildingHeightsEasy();
    System.out.println(obj.minimum(2, new int[] {1,2,1,4,3}));
    System.out.println(obj.minimum(3, new int[] {1,3,5,2,1}));
    System.out.println(obj.minimum(1, new int[] {43,19,15}));
    System.out.println(obj.minimum(3, new int[] {19,23,9,12}));
    System.out.println(obj.minimum(12, new int[] {25, 18, 38, 1, 42, 41, 14, 16, 19, 46, 42, 39, 38, 31, 43, 37, 26, 41, 33, 37, 45, 27, 19, 24, 33, 11, 22, 20, 36, 4, 4}));
  }

}
