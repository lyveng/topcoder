import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class SortingSubsets {
	
	public int getMinimalSize(int[] a) {
		int[] b = Arrays.copyOf(a, a.length);
		int size = 0;
		Arrays.sort(b);
		for (int i=0;i<a.length;i++)
			if (a[i] != b[i])
				size++;
		return size;
	}
}
