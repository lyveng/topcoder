package srm165.division2;

/**
 * Level 3 problem.
 * 
 * @author emmanuel
 *
 */
public class ShortPalindromes {
  int MAX_LENGTH = 25;
  String[][] dp = new String[MAX_LENGTH][MAX_LENGTH];

  public String shortest(String base) {
    return shortestUtil(base, 0, base.length() - 1);
  }

  private String shortestUtil(String base, int start, int end) {
    if (dp[start][end] != null) {
      return dp[start][end];
    }
    if (start == end) {
      dp[start][end] = base.substring(start, end + 1);
      return dp[start][end];
    }
    else if (start > end)
      return "";
    if (base.charAt(start) == base.charAt(end)) {
      StringBuilder sb = new StringBuilder();
      sb.append(base.charAt(start));
      sb.append(shortestUtil(base, start+1, end-1));
      sb.append(base.charAt(end));
      dp[start][end] = sb.toString();
      return dp[start][end];
    }
    StringBuilder leftSb = new StringBuilder();
    leftSb.append(base.charAt(start));
    leftSb.append(shortestUtil(base, start + 1, end));
    leftSb.append(base.charAt(start));
    StringBuilder rightSb = new StringBuilder();
    rightSb.append(base.charAt(end));
    rightSb.append(shortestUtil(base, start, end - 1));
    rightSb.append(base.charAt(end));
    String left = leftSb.toString();
    String right = rightSb.toString();
    if (left.length() == right.length()) {
      if (left.compareTo(right) < 0)
        dp[start][end] = left;
      else
        dp[start][end] = right;
    } else if (left.length() < right.length())
      dp[start][end] = left;
    else
      dp[start][end] = right;
    return dp[start][end];
  }
}
