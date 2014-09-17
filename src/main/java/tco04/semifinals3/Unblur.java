package tco04.semifinals3;
/**
 * Level1 problem.
 * 
 * @author emmanuel
 *
 */
public class Unblur {

  public String[] original(String[] blurred) {
    final int rows = blurred.length, cols = blurred[0].length();
    int[][] blur = new int[rows + 2][cols + 2];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        blur[i + 1][j + 1] = blurred[i].charAt(j) - '0';
      }
    }
    int[] dr = {-2, -2, -2, -1, -1, -1, 0, 0};
    int[] dc = {-2, -1, 0, -2, -1, 0, -2, -1};
    int[][] orig = new int[rows + 2][cols + 2];
    for (int i = 2; i < rows; i++) {
      for (int j = 2; j < cols; j++) {
        orig[i][j] = blur[i - 1][j - 1];
        for (int k = 0; k < dr.length; k++) {
          orig[i][j] -= orig[i + dr[k]][j + dc[k]];
        }
      }
    }
    String[] original = new String[rows];
    for (int i = 0; i < rows; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < cols; j++) {
        sb.append(orig[i + 1][j + 1] == 0 ? '.' : '#');
      }
      original[i] = sb.toString();
    }
    return original;
  }

}
