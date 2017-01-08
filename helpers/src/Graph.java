import java.util.LinkedList;
import java.util.List;

/**
 * Created by livingstone.se on 08/01/17.
 */
public class Graph {
    int V;
    List<Integer>[] adj;

    public Graph(int v) {
        V = v;
        adj = new List[v];
        for (int i=0;i<v;i++)
            adj[i] = new LinkedList<>();
    }
}
