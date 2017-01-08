import java.util.LinkedList;
import java.util.List;

/**
 * Created by livingstone.se on 08/01/17.
 */
public class EdgeWeightedGraph {
    public int V;
    public List<WeightedEdge>[] adj;

    public EdgeWeightedGraph(int v) {
        V = v;
        adj = new List[v];
        for (int i=0;i<v;i++)
            adj[i] = new LinkedList<>();
    }

    public void addEdge(WeightedEdge e) {
        adj[e.either()].add(e);
        adj[e.other(e.either())].add(e);
    }
}
