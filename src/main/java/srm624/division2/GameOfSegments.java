package srm624.division2;

/**
 * Level 3 problem.
 * 
 * @author emmanuel
 *
 */
public class GameOfSegments {
  public int winner(int N) {
    boolean[] win = new boolean[N+1];
    int k;
    win[2] = true;
    win[3] = true;
    for (int i=4;i<=N;i++) {
      // check side.
      if (!win[i-2])
      {
        win[i-2] = true;
        continue;
      }
      // check diagonal
      for (int j=1;j<=(i-3);j++)
      {
        k = i-2-1;
        if (!win[j] && !win[k])
        {
          win[i] = true;
          break;
        }
      }
    }
    return win[N] ? 1 : 2;
  }

  public static void main(String[] args) {
    GameOfSegments obj = new GameOfSegments();
    System.out.println(obj.winner(3));
    System.out.println(obj.winner(4));
    System.out.println(obj.winner(15));
    System.out.println(obj.winner(191));
  }

}
