package srm625.division2;

import java.util.ArrayList;
import java.util.List;

/**
 * Level 3 Problem
 * 
 * @author emmanuel
 *
 */
public class ConundrumReloaded {
  private int minimumLiarsLine(List<Character> arr) {
    boolean isHonest;
    int minLiars = Integer.MAX_VALUE, liarCount;
    for (int i=0;i<2;i++) {
      isHonest = i == 0;
      liarCount = 0;
      for (Character c : arr)
        if (isHonest)
          isHonest = c == 'H';
        else {
          isHonest = c == 'L';
          liarCount++;
        }
      if (!isHonest)
        liarCount++;
      if (liarCount < minLiars)
        minLiars = liarCount;
    }
    return minLiars;
  }

  private int minimumLiarsCyclic(boolean isFirstPersonHonest, String answers) {
    boolean isHonest = isFirstPersonHonest;
    int liarCount = 0;
    for (int i = 0; i < answers.length(); i++) {
      if (isHonest)
        isHonest = answers.charAt(i) == 'H';
      else {
        isHonest = answers.charAt(i) == 'L';
        liarCount++;
      }
    }
    if (isFirstPersonHonest == isHonest)
      return liarCount;
    return Integer.MAX_VALUE;
  }

  public int minimumLiars(String answers) {
    int minLiars = Integer.MAX_VALUE, liarCount;
    if (answers.contains("?")) {
      liarCount = 0;
      int firstUnknownIndex = answers.indexOf('?', 0), i = (firstUnknownIndex + 1) % answers.length();
      while (i != firstUnknownIndex) {
        while (answers.charAt(i) == '?' && i != firstUnknownIndex)
          i = (i + 1) % answers.length();
        List<Character> arr = new ArrayList<>();
        while (answers.charAt(i) != '?') {
          arr.add(answers.charAt(i));
          i = (i + 1) % answers.length();
        }
        liarCount += minimumLiarsLine(arr);
      }
      minLiars = liarCount;
    } else {
      minLiars = Math.min(minLiars, minimumLiarsCyclic(true, answers));
      minLiars = Math.min(minLiars, minimumLiarsCyclic(false, answers));
    }
    return minLiars == Integer.MAX_VALUE ? -1 : minLiars;
  }

  public static void main(String[] args) {
    ConundrumReloaded obj = new ConundrumReloaded();
    System.out.println(obj.minimumLiars("LLH"));
    System.out.println(obj.minimumLiars("?????"));
    System.out.println(obj.minimumLiars("LHLH?"));
    System.out.println(obj.minimumLiars("??LLLLLL??"));
    System.out.println(obj.minimumLiars("LLL"));
    System.out.println(obj.minimumLiars("?L?L?L?L?L"));
  }
}
