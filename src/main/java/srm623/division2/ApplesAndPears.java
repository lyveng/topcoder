package srm623.division2;

/**
 * Level 3 problem
 * 
 * @author emmanuel
 *
 */
public class ApplesAndPears {
  public int getArea(String[] board, int K) {
    int[][] p = new int[board.length + 1][board.length + 1];
    int[][] a = new int[board.length + 1][board.length + 1];
    int[][] e = new int[board.length + 1][board.length + 1];
    for (int x0 = 1; x0 <= board.length; x0++) {
      for (int y0 = 1; y0 <= board.length; y0++) {
        p[x0][y0] = (board[x0 - 1].charAt(y0 - 1) == 'P' ? 1 : 0) + p[x0 - 1][y0] + p[x0][y0 - 1] - p[x0 - 1][y0 - 1];
        a[x0][y0] = (board[x0 - 1].charAt(y0 - 1) == 'A' ? 1 : 0) + a[x0 - 1][y0] + a[x0][y0 - 1] - a[x0 - 1][y0 - 1];
        e[x0][y0] = (board[x0 - 1].charAt(y0 - 1) == '.' ? 1 : 0) + e[x0 - 1][y0] + e[x0][y0 - 1] - e[x0 - 1][y0 - 1];
      }
    }
    int maxRectSize = 1, pCount = p[board.length][board.length], aCount = a[board.length][board.length];
    int eCount = e[board.length][board.length], curPCount, curACount, curECount, rectSize, moves;
    for (int x0 = 0; x0 < board.length; x0++) {
      for (int y0 = 0; y0 < board.length; y0++) {
        for (int x1 = x0+1; x1 <= board.length; x1++) {
          for (int y1 = y0+1; y1 <= board.length; y1++) {
            rectSize = (x1 - x0) * (y1 - y0);
            if (rectSize <= maxRectSize)
              continue;
            curPCount = p[x1][y1] - p[x0][y1] - p[x1][y0] + p[x0][y0];
            curACount = a[x1][y1] - a[x0][y1] - a[x1][y0] + a[x0][y0];
            curECount = e[x1][y1] - e[x0][y1] - e[x1][y0] + e[x0][y0];

            // Check if pears can be filled.
            moves = 0;
            if (rectSize <= pCount) {
              // fill empty spaces inside the selected rectangle with pears
              moves += (curECount);
              if (curACount > 0) {
                if (eCount > 0) {
                  moves += (2 * curACount);
                  if (moves <= K && rectSize > maxRectSize) {
                    maxRectSize = rectSize;
                    continue;
                  }
                }
              } else if (moves <= K && rectSize > maxRectSize) {
                maxRectSize = rectSize;
                continue;
              }
            }

            // Check if apples can be filled.
            moves = 0;
            if (rectSize <= aCount) {
              moves += (curECount);
              if (curPCount > 0) {
                if (eCount > 0) {
                  moves += (2 * curPCount);
                  if (moves <= K && rectSize > maxRectSize) {
                    maxRectSize = rectSize;
                    continue;
                  }
                }
              } else if (moves <= K && rectSize > maxRectSize) {
                maxRectSize = rectSize;
                continue;
              }
            }

            // Check if empty spaces can be filled.
            moves = 0;
            if (rectSize <= eCount) {
              moves += (rectSize - curECount);
              if (moves <= K && rectSize > maxRectSize)
                maxRectSize = rectSize;
            }
          }
        }
      }
    }
    return maxRectSize;
  }

  public static void main(String[] args) {
    ApplesAndPears obj = new ApplesAndPears();
    System.out.println(obj.getArea(new String[] {".A", "P."}, 0));
    System.out.println(obj.getArea(new String[] {".A", "P."}, 1));
    System.out.println(obj.getArea(new String[] {".PP", "PPA", "PAP"}, 3));
    /*
     * System.out.println(obj.getArea(new String[] {}, )); System.out.println(obj.getArea(new
     * String[] {}, ));
     */
  }

}
