import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class FibonacciDiv2 {
	
	public int find(int N) {
		int a=0, b=1, c;
		if (N == 1)
			return 0;
		while (true) {
			c = a+b;
			if (N <= c) {
				return Math.min(N - b, c - N);
			}
			a = b;
			b = c;
		}
	}
}
