import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class TreeAndVertex {
	
	public int get(int[] tree) {
		int[] degree = new int[tree.length+1];
		for (int i=0;i<tree.length;i++) {
			degree[tree[i]]++;
			degree[i+1]++;
		}
		int max = 0;
		for (int i=1;i<degree.length;i++) {
			if (degree[i] > degree[max])
				max = i;
		}
		return degree[max];
	}
}
