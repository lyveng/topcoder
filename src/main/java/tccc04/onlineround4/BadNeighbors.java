package tccc04.onlineround4;

import java.util.Arrays;

public class BadNeighbors {

  public int maxDonations(int[] donations) {
    if (donations.length == 1)
      return donations[0];
    return Math.max(maxDonationsUtil(Arrays.copyOfRange(donations, 0, donations.length - 1)),
        maxDonationsUtil(Arrays.copyOfRange(donations, 1, donations.length)));
  }

  private int maxDonationsUtil(int[] donations) {
    int[] max = new int[donations.length];
    if (donations.length == 1)
      return donations[0];
    else if (donations.length == 2)
      return Math.max(donations[0], donations[1]);
    else if (donations.length == 3)
      return Math.max(donations[0], Math.max(donations[1], donations[2]));
    max[0] = donations[0];
    max[1] = Math.max(donations[0], donations[1]);
    max[2] = Math.max(donations[2] + max[0], max[1]);
    for (int i = 3; i < donations.length; i++) {
      max[i] = Math.max(max[i - 2] + donations[i], max[i - 3] + donations[i - 1]);
    }
    return max[donations.length - 1];
  }
}
