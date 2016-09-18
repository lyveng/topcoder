import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class TriangleMaking {
	
	public int maxPerimeter(int a, int b, int c) {
		int[] val = new int[] {a,b,c};
		Arrays.sort(val);
		if (val[0]+val[1] > val[2])
			return a+b+c;
		return 2*(val[0] + val[1]) - 1;
	}
}
