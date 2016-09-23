import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class SetPartialOrder {
	boolean less(int[] a, int[] b) {
		boolean less = true;
		for (int i=0;i<a.length;i++) {
			boolean found = false;
			for (int j=0;j<b.length;j++)
				if (a[i] == b[j]) {
					found = true;
					break;
				}
			if (!found) {
				less = false;
				break;
			}
		}
		return less;
	}
	
	public String compareSets(int[] a, int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);
		if (a.length == b.length) {
			for (int i=0;i<a.length;i++)
				if (a[i] != b[i])
					return "INCOMPARABLE";
			return "EQUAL";
		} else if (a.length < b.length) {
			if (less(a, b))
				return "LESS";
		} else {
			if (less(b, a))
				return "GREATER";
		}
		return "INCOMPARABLE";
	}
}
