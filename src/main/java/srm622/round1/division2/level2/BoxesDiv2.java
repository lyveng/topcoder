package srm622.round1.division2.level2;

import java.util.PriorityQueue;

public class BoxesDiv2 {
  public int findSize(int[] candyCounts) {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    for (int count : candyCounts)
      q.add(getBoxVolumeForCandy(count));
    int a,b,l;
    while (q.size() > 1) {
      a = q.remove();
      b = q.remove();
      l = a > b ? a : b;
      q.add(l*2);
    }
    assert q.size() == 1;
    return q.peek();
  }

  private int getBoxVolumeForCandy(int count) {
    int floorValue = (int) (Math.log10(count) / Math.log10(2));
    if (Math.pow(2, floorValue) == count)
      return count;
    return (int) Math.pow(2, floorValue+1);
  }

  public static void main(String[] args) {
    BoxesDiv2 obj = new BoxesDiv2();
    System.out.println(obj.findSize(new int[] {8,8}));
    System.out.println(obj.findSize(new int[] {5,6}));
    System.out.println(obj.findSize(new int[] {1,7}));
    System.out.println(obj.findSize(new int[] {1,1,13,1,1}));
    System.out.println(obj.findSize(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32}));
  }

}
