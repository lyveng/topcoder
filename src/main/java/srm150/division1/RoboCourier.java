package srm150.division1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


public class RoboCourier {

  private Map<Node, Integer> map;

  public int timeToDeliver(String[] path) {
    int[] dx = {0, -1, -1, 0, 1, 1};
    int[] dy = {2, 1, -1, -2, -1, 1};
    int dir = 0, count = 0;
    Node cur = new Node(0, 0);
    map = new HashMap<>();
    Graph g = new Graph();
    map.put(cur, 0);
    g.addNode();
    count++;
    Node start = new Node(0, 0);
    for (String pathIter : path) {
      for (char c : pathIter.toCharArray()) {
        if (c == 'R') {
          dir = (dir + 1) % dx.length;
        } else if (c == 'L') {
          dir = (dir + 5) % dx.length;
        } else {
          Node next = new Node(cur.x + dx[dir], cur.y + dy[dir]);
          if (!map.containsKey(next)) {
            map.put(next, count);
            count++;
            g.addNode();
          }
          g.addEdge(map.get(cur), map.get(next));
          cur = next;
        }
      }
    }
    Node target = cur;

    PriorityQueue<State> pq = new PriorityQueue<>();
    pq.add(new State(start, 0, 0, 0));
    boolean[] visited = new boolean[count * 6];
    int ret = Integer.MAX_VALUE;
    while (!pq.isEmpty()) {
      State top = pq.remove();
      if (visited[top.getVisitedArrayNum()])
        continue;
      visited[top.getVisitedArrayNum()] = true;

      if (top.node.equals(target) && top.cost < ret) {
        ret = top.cost;
      }

      // Move forward
      State prev = top;
      Node nextNode = new Node(prev.node.x + dx[prev.dir], prev.node.y + dy[prev.dir]);
      int newCost = prev.cost + (prev.mov < 2 ? 4 : 2);
      State nextState = new State(nextNode, prev.dir, newCost, Math.min(2, prev.mov + 1));
      while (g.adj.get(map.get(prev.node)).contains(map.get(nextNode)) && !visited[nextState.getVisitedArrayNum()]) {
        pq.add(nextState);
        prev = nextState;
        newCost = prev.cost + (prev.mov < 2 ? 4 : 2);
        nextNode = new Node(prev.node.x + dx[prev.dir], prev.node.y + dy[prev.dir]);
        nextState = new State(nextNode, prev.dir, newCost, Math.min(2, prev.mov + 1));
      }

      // Rotate right
      int nextDir = (top.dir + 1) % dx.length;
      nextState = new State(top.node, nextDir, top.cost + 3, 0);
      if (!visited[nextState.getVisitedArrayNum()])
        pq.add(nextState);

      // Rotate left
      nextDir = top.dir - 1;
      if (nextDir < 0)
        nextDir += dx.length;
      nextState = new State(top.node, nextDir, top.cost + 3, 0);
      if (!visited[nextState.getVisitedArrayNum()])
        pq.add(nextState);
    }
    return ret;
  }

  class Node {
    int x, y;

    Node(int x, int y) {
      super();
      this.x = x;
      this.y = y;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + getOuterType().hashCode();
      result = prime * result + x;
      result = prime * result + y;
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
      if (x != other.x)
        return false;
      if (y != other.y)
        return false;
      return true;
    }

    private RoboCourier getOuterType() {
      return RoboCourier.this;
    }
  }

  class Graph {
    List<Set<Integer>> adj = new ArrayList<>();

    public void addEdge(int u, int v) {
      assert u < adj.size() && v < adj.size();
      adj.get(u).add(v);
      adj.get(v).add(u);
    }

    public void addNode() {
      adj.add(new HashSet<Integer>());
    }
  }

  class State implements Comparable<State> {
    int cost, dir, mov;
    Node node;
    String path;

    State(Node node, int dir, int cost, int mov) {
      super();
      this.node = node;
      this.dir = dir;
      this.cost = cost;
      this.mov = mov;
    }

    @Override
    public int compareTo(State o) {
      return this.cost - o.cost;
    }

    int getVisitedArrayNum() {
      return map.get(node) * 6 + dir;
    }
  }
}
