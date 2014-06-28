package srm232.division2;

import java.util.Arrays;

public class WordFind {
  public String[] findWords(String[] grid, String[] wordList) {
    String[] ret = new String[wordList.length];
    for (int i = 0; i < wordList.length; i++) {
      boolean found = false;
      String word = wordList[i];
      for (int a = 0; a < grid.length; a++) {
        for (int b = 0; b < grid[0].length(); b++) {
          if (isFound(grid, word, a, b)) {
            ret[i] = String.format("%d %d", a, b);
            found = true;
            break;
          }
        }
        if (found)
          break;
      }
      if (!found)
        ret[i] = "";
    }
    return ret;
  }

  private boolean isFound(String[] grid, String word, int row, int col) {
    return isFoundDiagonally(grid, word, row, col) || isFoundHorizontally(grid, word, row, col) || isFoundVertically(grid, word, row, col);
  }

  private boolean isFoundHorizontally(String[] grid, String word, int row, int col) {
    boolean found = true;
    for (int i = 0; i < word.length(); i++)
      if ((col + i) >= grid[0].length() || word.charAt(i) != grid[row].charAt(col + i)) {
        found = false;
        break;
      }
    if (found)
      return found;
    for (int i = 0; i < word.length(); i++)
      if ((col - i) < 0 || word.charAt(i) != grid[row].charAt(col - i)) {
        found = false;
        break;
      }
    return found;
  }

  private boolean isFoundVertically(String[] grid, String word, int row, int col) {
    boolean found = true;
    for (int i = 0; i < word.length(); i++)
      if ((row + i) >= grid.length || word.charAt(i) != grid[row + i].charAt(col)) {
        found = false;
        break;
      }
    if (found)
      return found;
    for (int i = 0; i < word.length(); i++)
      if ((row - i) < 0 || word.charAt(i) != grid[row - i].charAt(col)) {
        found = false;
        break;
      }
    return found;
  }

  private boolean isFoundDiagonally(String[] grid, String word, int row, int col) {
    boolean found = true;
    for (int i = 0; i < word.length(); i++)
      if ((row + i) >= grid.length || (col + i) >= grid[0].length() || word.charAt(i) != grid[row + i].charAt(col + i)) {
        found = false;
        break;
      }
    if (found)
      return found;
    for (int i = 0; i < word.length(); i++)
      if ((row - i) < 0 || (col - i) < 0 || word.charAt(i) != grid[row - i].charAt(col - i)) {
        found = false;
        break;
      }
    return found;
  }

  public static void main(String[] args) {
    WordFind obj = new WordFind();
    System.out.println(Arrays.toString(obj.findWords(new String[] {"TEST", "GOAT", "BOAT"}, new String[] {"GOAT", "BOAT", "TEST"})));
  }

}
