package srm204.division1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Level 1 problem.
 * 
 * @author emmanuel
 *
 */
public class Apothecary {

  public int[] balance(int W) {
    List<Integer> l = new ArrayList<>();
    int i = 0;
    while (W > 0) {
      if (W % 3 == 1) {
        l.add((int)Math.pow(3, i));
        W = W / 3;
      }
      else if (W % 3 == 2) {
        l.add(-(int)Math.pow(3, i));
        W = (W+1) / 3;
      }
      else
        W = W / 3;
      i++;
    }
    Collections.sort(l);
    int[] ret = new int[l.size()];
    for (int j = 0; j < ret.length; j++) {
      ret[j] = l.get(j);
    }
    return ret;
  }

}
