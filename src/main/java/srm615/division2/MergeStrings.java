package srm615.division2;

/**
 * Level 3 Problem.
 * 
 * @author emmanuel
 *
 */
public class MergeStrings {
  final int MAX_LENGTH = 51;
  // dp[sPos][aPos][bPos] is 1 if S[sPos] is set at A[aPos]. 4 if always A[aPos] after this
                       // is 2 if S[sPos] is set as B[bPos]. 5 if always B[bPos] after this
                       // is 3 if no solution exists in this path.
                       // is 0 if this path is not explored.
  int[][][] dp = new int[MAX_LENGTH][MAX_LENGTH][MAX_LENGTH];

  public String getmin(String S, String A, String B) {
    String ret = getMinUtil(new StringBuilder(S), A, B, 0, 0, 0);
    return ret == null ? "" : ret;
  }

  private String getMinUtil(StringBuilder S, String A, String B, int sPos, int aPos, int bPos) {
    if (dp[sPos][aPos][bPos] == 3)
      return null;
    else if (dp[sPos][aPos][bPos] != 0)
      return getString(S, A, B, sPos, aPos, bPos);
    String ret = null;
    if (aPos < A.length() && bPos < B.length()) {
      if (S.charAt(sPos) == '?') {
        S.setCharAt(sPos, A.charAt(aPos));
        String aRet = getMinUtil(S, A, B, sPos + 1, aPos + 1, bPos);
        S.setCharAt(sPos, B.charAt(bPos));
        String bRet = getMinUtil(S, A, B, sPos + 1, aPos, bPos + 1);
        if (aRet != null && bRet != null) {
          if (aRet.compareTo(bRet) < 0) {
            ret = aRet;
            dp[sPos][aPos][bPos] = 1;
          } else {
            ret = bRet;
            dp[sPos][aPos][bPos] = 2;
          }
        } else if (aRet != null) {
          ret = aRet;
          dp[sPos][aPos][bPos] = 1;
        } else if (bRet != null) {
          ret = bRet;
          dp[sPos][aPos][bPos] = 2;
        } else
          dp[sPos][aPos][bPos] = 3;
        S.setCharAt(sPos, '?');
      } else if (S.charAt(sPos) == A.charAt(aPos) && S.charAt(sPos) == B.charAt(bPos)) {
        String aRet = getMinUtil(S, A, B, sPos + 1, aPos + 1, bPos);
        String bRet = getMinUtil(S, A, B, sPos + 1, aPos, bPos + 1);
        if (aRet != null && bRet != null) {
          if (aRet.compareTo(bRet) < 0) {
            ret = aRet;
            dp[sPos][aPos][bPos] = 1;
          } else {
            ret = bRet;
            dp[sPos][aPos][bPos] = 2;
          }
        } else if (aRet != null) {
          ret = aRet;
          dp[sPos][aPos][bPos] = 1;
        } else if (bRet != null) {
          ret = bRet;
          dp[sPos][aPos][bPos] = 2;
        } else
          dp[sPos][aPos][bPos] = 3;

      } else if (S.charAt(sPos) == A.charAt(aPos)) {
        ret = getMinUtil(S, A, B, sPos + 1, aPos + 1, bPos);
        dp[sPos][aPos][bPos] = ret == null ? 3 : 1;
      } else if (S.charAt(sPos) == B.charAt(bPos)) {
        ret = getMinUtil(S, A, B, sPos + 1, aPos, bPos + 1);
        dp[sPos][aPos][bPos] = ret == null ? 3 : 2;
      } else
        dp[sPos][aPos][bPos] = 3;
    } else if (aPos < A.length()) {
      ret = getStringIfMatching(S, A, sPos, aPos);
      dp[sPos][aPos][bPos] = ret == null ? 3 : 4;
    } else if (bPos < B.length()) {
      ret = getStringIfMatching(S, B, sPos, bPos);
      dp[sPos][aPos][bPos] = ret == null ? 3 : 5;
    }
    return ret;
  }

  private String getStringIfMatching(StringBuilder sb, String p, int sPos, int pos) {
    StringBuilder s = new StringBuilder(sb.toString());
    while (sPos < s.length()) {
      if (s.charAt(sPos) == '?')
        s.setCharAt(sPos++, p.charAt(pos++));
      else if (s.charAt(sPos) == p.charAt(pos++))
        sPos++;
      else
        return null;
    }
    return s.toString();
  }

  private String getString(StringBuilder sb, String a, String b, int sPos, int aPos, int bPos) {
    StringBuilder s = new StringBuilder(sb.toString());
    while (sPos < s.length()) {
      int val = dp[sPos][aPos][bPos];
      if (val == 1)
        s.setCharAt(sPos++, a.charAt(aPos++));
      else if (val == 2)
        s.setCharAt(sPos++, b.charAt(bPos++));
      else if (val == 4)
        while (sPos < s.length())
          s.setCharAt(sPos++, a.charAt(aPos++));
      else if (val == 5)
        while (sPos < s.length())
          s.setCharAt(sPos++, b.charAt(bPos++));
      else
        System.out.println("ERROR");
    }
    return s.toString();
  }
}
