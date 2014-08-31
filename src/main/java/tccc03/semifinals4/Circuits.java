package tccc03.semifinals4;

/**
 * Level 1 problem.
 * 
 * @author emmanuel
 *
 */
public class Circuits {

  public int howLong(String[] connects, String[] costs) {
    int V = connects.length;
    int[][] cost = new int[V][V];
    for (int i = 0; i < V; i++) {
      if (connects[i].length() == 0) continue;
      String[] connectSplit = connects[i].split(" "), costSplit = costs[i].split(" ");
      for (int j = 0; j < connectSplit.length; j++) {
        int v = Integer.parseInt(connectSplit[j]), w = Integer.parseInt(costSplit[j]);
        if (w > cost[i][v])
          cost[i][v] = w;
      }
    }

    for (int k = 0; k < V; k++) {
      for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
          if (cost[i][k] != 0 && cost[k][j] != 0 && cost[i][j] < cost[i][k]+cost[k][j]) {
            cost[i][j] = cost[i][k]+cost[k][j];
          }
        }
      }
    }
    int maxCost = Integer.MIN_VALUE;
    for (int i = 0; i < cost.length; i++) {
      for (int j = 0; j < cost.length; j++) {
        maxCost = Math.max(maxCost, cost[i][j]);
      }
    }
    return maxCost;
  }

  
}
