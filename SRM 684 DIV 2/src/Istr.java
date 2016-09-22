import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Istr {
	
	public int count(String s, int k) {
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[(int)(c - 'a')]++;
		}
		Arrays.sort(count);
		int sum = 0;
		for (int i=0;i<k;i++) {
			count[25]--;
			Arrays.sort(count);
		}
		for (int i=0;i<26;i++)
			sum += (count[i]*count[i]);
		return sum;
	}
}
