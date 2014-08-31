package tccc03.regional.quarterfinals;
import java.util.HashSet;
import java.util.Set;

public class Marketing {

  public long howMany(String[] compete) {
    Graph g = new Graph(compete.length);
    for (int i=0;i<compete.length;i++) {
      String string = compete[i];
      if (string.length() == 0)
        continue;
      String[] split = string.split(" ");
      for (String u : split) {
        g.addEdge(i, Integer.parseInt(u));
      }
    }
    Bipartite b = new Bipartite(g);
    if (!b.isBipartite)
      return -1;
    return 1l << b.components;
  }

  class Graph {
    int V;
    Set<Integer>[] adj;

    Graph(int v) {
      super();
      this.V = v;
      adj = (Set<Integer>[]) new Set[v];
      for (int i = 0; i < v; i++) {
        adj[i] = new HashSet<>();
      }
    }

    void addEdge(int u, int v) {
      adj[u].add(v);
      adj[v].add(u);
    }
  }

  class Bipartite {
    boolean[] visited;
    boolean[] color;
    boolean isBipartite;
    int components;

    Bipartite(Graph g) {
      super();
      visited = new boolean[g.V];
      color = new boolean[g.V];
      components = 0;
      isBipartite = true;
      for (int i = 0; i < g.V; i++) {
        if (!visited[i] && isBipartite) {
          components++;
          dfs(g, i);
        }
      }
    }

    private void dfs(Graph g, int u) {
      if (!isBipartite)
        return;
      visited[u] = true;
      for (int v : g.adj[u]) {
        if (!visited[v]) {
          color[v] = !color[u];
          dfs(g, v);
        }
        else if (color[v] == color[u]) {
          isBipartite = false;
          break;
        }
      }
    }
  }
}
