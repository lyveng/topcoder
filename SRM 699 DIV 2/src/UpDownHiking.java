import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class UpDownHiking {
	
	public int maxHeight(int N, int A, int B) {
		int ret = 0, n=N, alt=0;
		while (n > 0) {
			if (alt >= 0) {
				alt -= B;
			} else {
				alt += A;
				ret += A;
			}
			n--;
		}
		if (alt > 0)
			ret -= alt;
		return ret;
	}
}
