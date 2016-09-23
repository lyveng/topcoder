import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class PointDistance {
	
	public int[] findPoint(int x1, int y1, int x2, int y2) {
		int x3, y3;
		if (y1 > y2) {
			y3 = y2 - 1;
		} else {
			y3 = y2 + 1;
		}
		if (x1 > x2) {
			x3 = x2 - 1;
		} else {
			x3 = x2 + 1;
		}
		return new int[] {x3, y3};
	}
}
