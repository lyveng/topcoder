/**
 * Created by livingstone.se on 08/01/17.
 */
public class WeightedEdge implements Comparable<WeightedEdge> {
    public int u, v, weight;

    public WeightedEdge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public int either() {
        return u;
    }

    public int other(int u) {
        if (u == this.u)
            return this.v;
        else if (u == this.v)
            return this.u;
        throw new RuntimeException("Invalid vertex passwed to Edge.other");
    }

    @Override
    public int compareTo(WeightedEdge o) {
        return this.weight - o.weight;
    }
}
