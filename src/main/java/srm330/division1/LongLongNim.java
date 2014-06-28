package srm330.division1;

/**
 * Level 3 problem
 * 
 * @author emmanuel
 *
 */
public class LongLongNim {
  public int numberOfWins(int maxN, int[] moves) {
    boolean[] win = new boolean[maxN+1];
    int count = 0;
    for (int i=1;i<=maxN;i++) {
      for (int move : moves) {
        if (move <= i) {
          if (!win[i-move]) {
            win[i] = true;
            break;
          }
        }
      }
      if (!win[i])
        count++;
    }
    return count;
  }

  public static void main(String[] args) {
    LongLongNim obj = new LongLongNim();
    System.out.println(obj.numberOfWins(20, new int[] {1,2,3}));
    System.out.println(obj.numberOfWins(999, new int[] {1}));
    System.out.println(obj.numberOfWins(1000000000, new int[] {1,2}));
    System.out.println(obj.numberOfWins(6543, new int[] {2,4,7,11,20}));
  }

}
