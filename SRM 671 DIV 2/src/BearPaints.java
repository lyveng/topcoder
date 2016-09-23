import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class BearPaints {
	
	public long maxArea(int W, int H, long M) {
		long h, max=-1;
		for (long w=1;w<=W;w++) {
			h = Math.min(H, M/w);
			if (h*w > max)
				max = h*w;
		}
		return max;
	}
}
