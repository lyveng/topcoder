import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class MakingPairs {
	
	public int get(int[] card) {
		int sum = 0;
		for (int x : card) {
			sum += (x/2);
		}
		return sum;
	}
}
