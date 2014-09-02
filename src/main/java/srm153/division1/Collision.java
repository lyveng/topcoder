package srm153.division1;
public class Collision {

  public double probability(int[] assignments, int ids) {
    double p1 = 1., p2 = 1., sum = 0;
    done:
    for (int i = 0; i < assignments.length; i++) {
      if (assignments[i] > ids) {
        p1 = p2 = 0;
        break done;
      }
      for (int j = 0; j < assignments[i]; j++) {
        p1 *= ((ids - (sum + j)) / ids);
        p2 *= ((ids - (sum + j)) / (ids - j));
      }
      sum += assignments[i];
    }
    System.out.println(p1);
    System.out.println(p2);
    return p2 - p1;
  }

}
