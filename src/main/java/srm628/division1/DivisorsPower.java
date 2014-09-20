package srm628.division1;
import java.util.HashSet;
import java.util.Set;

/**
 * Level1 Problem.
 * 
 * @author emmanuel
 *
 */
public class DivisorsPower {
  int getRoot(long n, int d) {
    int x = (int) Math.floor(Math.pow(n, (double) 1.0 / d));
    if (x < 2)
      return -2;
    for (int i = x; i <= x+1; i++) {
      long nc = 1;
      for (int j = 0; j < d; j++) {
        nc *= i;
      }
      if (nc == n)
        return i;
    }
    return -1;
  }

  int getDivisorCount(int n) {
    Set<Integer> divisors = new HashSet<>();
    int maxDivisor = (int) Math.ceil(Math.sqrt(n));
    for (int i = 1; i < maxDivisor; i++) {
      if (n % i == 0)
        divisors.add(i);
    }
    int count = divisors.size() * 2;
    if (maxDivisor * maxDivisor == n)
      count++;
    return count;
  }

  public long findArgument(long n) {
    long ret = -1;
    for (int d=2; d<60;d++) {
      int x = getRoot(n, d);
      if (x == -2)
        break;
      else if (x == -1)
        continue;
      int count = getDivisorCount(x);
      if (count == d) {
        long nc = 1;
        for (int i = 0; i < d; i++) {
          nc *= x;
        }
        if (nc == n)
          ret = x;
      }
    }
    return ret;
  }

}
