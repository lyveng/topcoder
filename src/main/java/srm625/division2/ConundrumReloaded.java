package srm625.division2;

/**
 * Level 3 problem.
 * 
 * @author emmanuel
 *
 */
public class ConundrumReloaded {
  
  public int minimumLiars(String answers)
  {
      int minLiars = Integer.MAX_VALUE;
      boolean feasible, jLiar, jp1Liar ;
      for (long i=0;i<1<<answers.length();i++) {
        int liarCount = 0;
        for (int j=0;j<answers.length();j++)
          if ((i & (1<<j)) == 0)
            liarCount++;
        feasible = true;
        for (int j=0;j<answers.length();j++) {
          jLiar = ((i & (1<<j)) == 0);
          jp1Liar = ((i & (1<<((j+1) % answers.length()))) == 0);
          if (jLiar) {
            if ((answers.charAt(j) == 'H' && jp1Liar) || (answers.charAt(j) == 'L' && !jp1Liar) || answers.charAt(j) == '?')
              continue;
            else {
              feasible = false;
              break;
            }
          }
          else {
            if ((answers.charAt(j) == 'L' && jp1Liar) || (answers.charAt(j) == 'H' && !jp1Liar) || answers.charAt(j) == '?')
              continue;
            else {
              feasible = false;
              break;
            }
          }
        }
        if (feasible && liarCount < minLiars)
          minLiars = liarCount;
      }
      if (minLiars == Integer.MAX_VALUE)
        return -1;
      return minLiars;
  }

  public static void main(String[] args) {
    ConundrumReloaded obj = new ConundrumReloaded();
    System.out.println(obj.minimumLiars("LLH"));
    System.out.println(obj.minimumLiars("?????"));
    System.out.println(obj.minimumLiars("LHLH?"));
    System.out.println(obj.minimumLiars("??LLLLLL??"));
    System.out.println(obj.minimumLiars("LLL"));
  }

}
