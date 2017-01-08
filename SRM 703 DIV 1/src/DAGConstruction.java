import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class DAGConstruction {
	
	public int[] construct(int[] x) {
		List<Vertex> vertices = new ArrayList<>();
		for (int i=0;i<x.length;i++) {
			vertices.add(new Vertex(i, x[i]));
		}
		Collections.sort(vertices);
		List<Integer> ret = new LinkedList<>();
		for (int i=0;i<x.length;i++) {
			if (vertices.get(i).reachable > i + 1)
				return new int[]{-1};
			for (int j=0;j<vertices.get(i).reachable-1;j++) {
				ret.add(vertices.get(i).u);
				ret.add(vertices.get(j).u);
			}
		}
		int[] retVal = new int[ret.size()];
		for (int i=0;i<retVal.length;i++)
			retVal[i] = ret.get(i);
		return retVal;
	}

	public class Vertex implements Comparable<Vertex> {
		int u, reachable;

		public Vertex(int u, int reachable) {
			this.u = u;
			this.reachable = reachable;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.reachable - o.reachable;
		}
	}
}
