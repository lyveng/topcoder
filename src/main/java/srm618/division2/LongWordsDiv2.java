package srm618.division2;

/**
 * Level 2 Problem.
 * 
 * @author emmanuel
 * 
 */
public class LongWordsDiv2 {
  public String find(String word) {
    for (int i = 0; i < word.length() - 1; i++)
      if (word.charAt(i) == word.charAt(i + 1))
        return "Dislikes";
    if (findUtil(word, new char[] {0, 0, 0, 0}, 0, 0, word.length()))
      return "Likes";
    else
      return "Dislikes";
  }

  public boolean findUtil(String fullWord, char[] word, int pos, int index, int maxIndex) {
    if (pos == 4) {
      if (word[0] == word[2] && word[1] == word[3])
        return false;
      return true;
    }
    if (index == maxIndex)
      return true;
    for (int i = index; i < maxIndex; i++) {
      word[pos] = fullWord.charAt(i);
      if (!findUtil(fullWord, word, pos + 1, i + 1, maxIndex))
        return false;
      if (!findUtil(fullWord, word, pos, i + 1, maxIndex))
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    LongWordsDiv2 obj = new LongWordsDiv2();
    System.out.println(obj.find("TOPCODER"));
  }

}
