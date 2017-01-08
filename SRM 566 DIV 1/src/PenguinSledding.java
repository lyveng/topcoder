import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class PenguinSledding {
	
	public long countDesigns(int numCheckpoints, int[] checkpoint1, int[] checkpoint2) {
		Set<Integer>[] adj = new Set[numCheckpoints];
		for (int i=0;i<numCheckpoints;i++) {
			adj[i] = new HashSet<>();
		}
		for (int i=0;i<checkpoint1.length;i++) {
			adj[checkpoint1[i]-1].add(checkpoint2[i]-1);
			adj[checkpoint2[i]-1].add(checkpoint1[i]-1);
		}

		long retVal = 1; // no checkpoints chosen case
		retVal += checkpoint1.length; // one endpoint chosen
		// calculate triplets
		Set<Triplet> triplets = new HashSet<>();
		for (int i=0;i<checkpoint1.length;i++) {
			int u = checkpoint1[i]-1;
			int v = checkpoint2[i]-1;
			for (int w=0;w < numCheckpoints;w++) {
				if (w == u || w == v)
					continue;
				if (adj[u].contains(w) && adj[v].contains(w))
					triplets.add(new Triplet(u, v, w));
			}
		}
		retVal += triplets.size();
		// calculate stars
		for (int i=0;i<numCheckpoints;i++) {
			if (adj[i].size() < 2)
				continue;
			retVal += ((1L << adj[i].size()) - adj[i].size() - 1);
		}
		return retVal;
	}

	public class Triplet {
		int u, v, w;

		public Triplet(int u, int v, int w) {
			int[] arr = new int[] {u, v, w};
			Arrays.sort(arr);
			this.u = arr[0];
			this.v = arr[1];
			this.w = arr[2];
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Triplet triplet = (Triplet) o;

			if (u != triplet.u) return false;
			if (v != triplet.v) return false;
			return w == triplet.w;

		}

		@Override
		public int hashCode() {
			int result = u;
			result = 31 * result + v;
			result = 31 * result + w;
			return result;
		}
	}
}
