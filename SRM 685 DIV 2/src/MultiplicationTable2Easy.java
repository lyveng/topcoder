import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class MultiplicationTable2Easy {
	
	public String isGoodSet(int[] table, int[] t) {
		boolean[] present = new boolean[50];
		for (int i : t)
			present[i] = true;
		int n = (int) Math.sqrt(table.length);
		for (int i=0;i<t.length;i++) {
			for (int j=0;j<t.length;j++) {
				if (!present[table[n*t[i] + t[j]]])
					return "Not Good";
			}
		}
		return "Good";
	}
}
