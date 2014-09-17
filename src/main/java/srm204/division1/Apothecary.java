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
    int i = 1, c = 0;
    while (W > 0) {
      if (W % 3 == 1) {
        if (c == 1)
          l.add(-i);
        else
          l.add(i);
      }
      else if (W % 3 == 2) {
        if (c == 0) {
          l.add(-i);
          c = 1;
        }
      }
      else {
        if (c == 1) {
          l.add(i);
          c = 0;
        }
      }
      W = W / 3;
      i*=3;
    }
    if (c == 1)
      l.add(i);
    Collections.sort(l);
    int[] ret = new int[l.size()];
    for (int j = 0; j < ret.length; j++) {
      ret[j] = l.get(j);
    }
    return ret;
  }

}
