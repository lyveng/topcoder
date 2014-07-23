package srm233.round1.division1.level2;

import java.util.*;

/**
 * The toy company "I Can't Believe It Works!" has hired you to help develop educational toys. The
 * current project is a word toy that displays four letters at all times. Below each letter are two
 * buttons that cause the letter above to change to the previous or next letter in alphabetical
 * order. So, with one click of a button the letter 'c' can be changed to a 'b' or a 'd'. The
 * alphabet is circular, so for example an 'a' can become a 'z' or a 'b' with one click. In order to
 * test the toy, you would like to know if a word can be reached from some starting word, given one
 * or more constraints. A constraint defines a set of forbidden words that can never be displayed by
 * the toy. Each constraint is formatted like "X X X X", where each X is a string of lowercase
 * letters. A word is defined by a constraint if the ith letter of the word is contained in the ith
 * X of the contraint. For example, the constraint "lf a tc e" defines the words "late", "fate",
 * "lace" and "face". You will be given a String start, a String finish, and a String[] forbid.
 * Calculate and return the minimum number of button presses required for the toy to show the word
 * finish if the toy was originally showing the word start. Remember, the toy must never show a
 * forbidden word. If it is impossible for the toy to ever show the desired word, return -1.
 * 
 * @author emmanuel
 * 
 */
public class SmartWordToy
{
  private int base_a = (int) 'a';

  private int encode(char[] s) {
    return s[0] - base_a + ((s[1] - base_a) << 5) + ((s[2] - base_a) << 10) + ((s[3] - base_a) << 15);
  }

  private boolean[] getForbidEncoded(String[] forbid) {
    boolean[] forbidArr = new boolean[1 << 20];
    for (String forbidStr : forbid) {
      String[] forbidStrSplit = forbidStr.split(" ");
      for (char a : forbidStrSplit[0].toCharArray()) {
        for (char b : forbidStrSplit[1].toCharArray()) {
          for (char c : forbidStrSplit[2].toCharArray()) {
            for (char d : forbidStrSplit[3].toCharArray()) {
              forbidArr[encode(new char[] {a, b, c, d})] = true;
            }
          }
        }
      }
    }
    return forbidArr;
  }

  public int minPresses(String start, String finish, String[] forbid) {
    boolean[] visitedArr = getForbidEncoded(forbid);
    int[] minDist = new int[1 << 20];
    char[] startArr = start.toCharArray(), finishArr = finish.toCharArray(), nextArr, curArr;
    int[] move_index = {0, 0, 1, 1, 2, 2, 3, 3};
    int[] move_delta = {1, -1, 1, -1, 1, -1, 1, -1};
    int curEnc, finishEnc=encode(finishArr), nextEnc;
    if (encode(startArr) == finishEnc)
      return 0;
    LinkedList<char[]> q = new LinkedList<>();
    q.add(startArr);
    visitedArr[encode(startArr)] = true;
    while (!q.isEmpty()) {
      curArr = q.remove();
      curEnc = encode(curArr);
      for (int i = 0; i < move_index.length; i++) {
        nextArr = curArr.clone();
        if (move_delta[i] == 1 && nextArr[move_index[i]] == 'z')
          nextArr[move_index[i]] = 'a';
        else if (move_delta[i] == -1 && nextArr[move_index[i]] == 'a')
          nextArr[move_index[i]] = 'z';
        else
          nextArr[move_index[i]] += move_delta[i];
        nextEnc = encode(nextArr);
        if (!visitedArr[nextEnc]) {
          if (nextEnc == finishEnc)
            return 1 + minDist[curEnc];
          minDist[nextEnc] = minDist[curEnc] + 1;
          visitedArr[nextEnc] = true;
          q.add(nextArr);
        }
      }
    }
    return -1;
  }

}