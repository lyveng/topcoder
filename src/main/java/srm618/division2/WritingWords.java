package srm618.division2;

/**
 * Level 1 Problem.
 * 
 * @author emmanuel
 * 
 */
public class WritingWords {
  public int write(String word) {
    int count = 0;
    for (int i = 0; i < word.length(); i++) {
      count += ((int) word.charAt(i) - (int) ('A') + 1);
    }
    return count;
  }

  public static void main(String[] args) {

  }

}
