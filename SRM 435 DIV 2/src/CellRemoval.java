import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CellRemoval {
	
	public int cellsLeft(int[] parent, int deletedCell) {
		Set<Integer> excludedVertices = new TreeSet<>();
		excludedVertices.add(deletedCell);
		int count=0, oldCount=-1;
		while (oldCount != count) {
			oldCount = count;
			count = 0;
			for (int i=0;i<parent.length;i++) {
				if (excludedVertices.contains(parent[i])) {
					excludedVertices.add(i);
					count++;
				}
			}
		}
		Set<Integer> parentSet = new TreeSet<>();
		for (int i=0;i<parent.length;i++)
			parentSet.add(parent[i]);

		int cellCount=0;
		for (int i=0;i<parent.length;i++) {
			if (excludedVertices.contains(i) || parentSet.contains(i))
				continue;
			cellCount++;
		}
		return cellCount;
	}
}
