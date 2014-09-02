package srm194.division1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Level 3 problem.
 * 
 * @author emmanuel
 *
 */
public class IslandFerries {
  private static final int MAX_STATES = 7040;
  private static final int MAX_TICKETS = 3;

  private Map<Node, Integer> map;
  private Map<Integer, Node> reverseMap;
  private int count = 0;
  private int noOfIslands;
  private int noOfFerryProviders;
  private int[][] prices;
  private Graph g = new Graph(MAX_STATES);
  private Graph[] baseGraph;

  public int[] costs(String[] legs, String[] prices) {
    noOfFerryProviders = legs.length;
    noOfIslands = prices.length;
    map = new HashMap<>();
    reverseMap = new HashMap<>();
    constructPrices(prices);
    constructBaseGraph(legs);
    count = 0;
    generateStates();

    int[] ret = new int[noOfIslands];
    Arrays.fill(ret, Integer.MAX_VALUE);
    ret[0] = 0;
    State start = new State(0, new Node(0, 0));
    PriorityQueue<State> pq = new PriorityQueue<>();
    pq.add(start);
    boolean[] visited = new boolean[MAX_STATES];
    while (!pq.isEmpty()) {
      State cur = pq.remove();
      if (visited[map.get(cur.node)])
        continue;
      visited[map.get(cur.node)] = true;
      if (cur.node.tickets == 0 && cur.cost < ret[cur.node.island])
        ret[cur.node.island] = cur.cost;
      for (Edge e : g.adj[map.get(cur.node)]) {
        if (!visited[e.v]) {
          State nextState = new State(cur.cost + e.w, reverseMap.get(e.v));
          pq.add(nextState);
        }
      }
      for (int t = 0; t < noOfFerryProviders; t++) {
        if ((cur.node.tickets & (1 << t)) == 0)
          continue;
        for (Edge e : baseGraph[t].adj[cur.node.island]) {
          State nextState = new State(cur.cost, new Node(cur.node.tickets & (~(1 << t)), e.v));
          if (!visited[map.get(nextState.node)])
            pq.add(nextState);
        }
      }
    }
    for (int i = 0; i < ret.length; i++) {
      if (ret[i] == Integer.MAX_VALUE)
        ret[i] = -1;
    }

    return Arrays.copyOfRange(ret, 1, ret.length);
  }

  private void constructBaseGraph(String[] legs) {
    baseGraph = new Graph[noOfFerryProviders];
    for (int i = 0; i < noOfFerryProviders; i++) {
      baseGraph[i] = new Graph(noOfIslands);
      if (legs[i].isEmpty())
        continue;
      String[] split = legs[i].split(" ");
      for (int j = 0; j < split.length; j++) {
        String[] leg = split[j].split("-");
        baseGraph[i].addEdge(Integer.parseInt(leg[0]), Integer.parseInt(leg[1]), 0);
      }
    }
  }

  private void constructPrices(String[] pricesArr) {
    prices = new int[noOfIslands][noOfFerryProviders];
    for (int i = 0; i < pricesArr.length; i++) {
      String[] split = pricesArr[i].split(" ");
      for (int j = 0; j < split.length; j++) {
        prices[i][j] = Integer.parseInt(split[j]);
      }
    }
  }

  private void generateStates() {
    for (int i = 0; i < noOfIslands; i++) {
      for (int t = 0; t <= Math.min(noOfFerryProviders, MAX_TICKETS); t++) {
        generateStatesUtil(i, 0, 0, t);
      }
    }
    for (int i = 0; i < noOfIslands; i++) {
      Node ticket0 = new Node(0, i);
      for (int a = 0; a < noOfFerryProviders; a++) {
        Node ticket1 = new Node(1 << a, i);
        g.addEdge(map.get(ticket0), map.get(ticket1), prices[i][a]);
        if (noOfFerryProviders == 1)
          continue;
        for (int b = 0; b < noOfFerryProviders; b++) {
          if (a == b)
            continue;
          Node ticket2 = new Node((1 << a) | (1 << b), i);
          g.addEdge(map.get(ticket1), map.get(ticket2), prices[i][b]);
          if (noOfFerryProviders == 2)
            continue;
          for (int c = 0; c < noOfFerryProviders; c++) {
            if (b == c)
              continue;
            Node ticket3 = new Node((1 << a) | (1 << b) | (1 << c), i);
            g.addEdge(map.get(ticket2), map.get(ticket3), prices[i][c]);
          }
        }
      }
    }
  }

  private void generateStatesUtil(int island, int curTickets, int nextTicketNum, int noOfTickets) {
    if (Integer.bitCount(curTickets) == noOfTickets) {
      reverseMap.put(count, new Node(curTickets, island));
      map.put(reverseMap.get(count), count);
      count++;
      return;
    }
    if (nextTicketNum == noOfFerryProviders)
      return;
    // do not take ticket
    generateStatesUtil(island, curTickets, nextTicketNum+1, noOfTickets);
    // take ticket
    generateStatesUtil(island, curTickets | (1 << nextTicketNum), nextTicketNum+1, noOfTickets);
  }

  class Graph {
    int size;
    Set<Edge>[] adj;
    Graph(int size) {
      super();
      this.size = size;
      adj = (Set<Edge>[]) new Set[size];
      for (int i = 0; i < size; i++) {
        adj[i] = new HashSet<>();
      }
    }

    void addEdge(int u, int v, int w) {
      adj[u].add(new Edge(u, v, w));
    }

    @Override
    public String toString() {
      return "Graph [size=" + size + ", adj=" + Arrays.toString(adj) + "]";
    }
  }

  class Edge {
    int u, v, w;

    public Edge(int u, int v, int w) {
      super();
      this.u = u;
      this.v = v;
      this.w = w;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + getOuterType().hashCode();
      result = prime * result + u;
      result = prime * result + v;
      result = prime * result + w;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Edge other = (Edge) obj;
      if (!getOuterType().equals(other.getOuterType()))
        return false;
      if (u != other.u)
        return false;
      if (v != other.v)
        return false;
      if (w != other.w)
        return false;
      return true;
    }

    private IslandFerries getOuterType() {
      return IslandFerries.this;
    }

    @Override
    public String toString() {
      return "Edge [u=" + u + ", v=" + v + ", w=" + w + "]";
    }
  }

  class Node {
    int tickets, island;

    public Node(int tickets, int island) {
      super();
      this.tickets = tickets;
      this.island = island;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + getOuterType().hashCode();
      result = prime * result + island;
      result = prime * result + tickets;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Node other = (Node) obj;
      if (!getOuterType().equals(other.getOuterType()))
        return false;
      if (island != other.island)
        return false;
      if (tickets != other.tickets)
        return false;
      return true;
    }

    private IslandFerries getOuterType() {
      return IslandFerries.this;
    }

    @Override
    public String toString() {
      return "Node [tickets=" + tickets + ", island=" + island + "]";
    }
  }

  class State implements Comparable<State> {
    int cost;
    Node node;
    public State(int cost, Node node) {
      super();
      this.cost = cost;
      this.node = node;
    }
    @Override
    public int compareTo(State o) {
      return Integer.compare(cost, o.cost);
    }
    @Override
    public String toString() {
      return "State [cost=" + cost + ", node=" + node + "]";
    }
  }
}
