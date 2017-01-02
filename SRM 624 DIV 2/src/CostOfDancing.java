import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CostOfDancing {
	
	public int minimum(int K, int[] danceCost) {
		Arrays.sort(danceCost);
		int sum = 0;
		for (int i=0;i<K;i++)
			sum+=danceCost[i];
		return sum;
	}
}
