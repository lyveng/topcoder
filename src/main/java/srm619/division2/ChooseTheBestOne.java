package srm619.division2;

import java.util.ArrayList;
import java.util.List;

/**
 * Level 2 problem.
 * 
 * @author emmanuel
 * 
 */
public class ChooseTheBestOne {
  public static int countNumber(int N) {
    List<Integer> tshirts = new ArrayList<>(N);
    for (int i = 1; i <= N; i++)
      tshirts.add(i);
    int i = 0;
    for (long t = 1; t < N; t++) {
      int remEmp = tshirts.size();
      i = (int) ((i + t * t * t - 1) % remEmp);
      tshirts.remove(i);
    }
    return tshirts.get(0);
  }

  public static void main(String[] args) {
    System.out.println(countNumber(1234));
  }

}
