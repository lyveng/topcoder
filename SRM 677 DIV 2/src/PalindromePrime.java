import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class PalindromePrime {
	
	public int count(int L, int R) {
		String s;
		int count=0;
		boolean isPalindrome, isPrime;
		for (int i=L;i<=R;i++) {
			if (i == 1)
				continue;

			isPalindrome = true;
			s = Integer.toString(i);
			for (int j=0;j<s.length()/2;j++) {
				if (s.charAt(j) != s.charAt(s.length()-1-j)) {
					isPalindrome = false;
					break;
				}
			}

			isPrime = true;
			for (int j=2;j<=Math.sqrt(i);j++) {
				if (i%j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPalindrome && isPrime)
				count++;
		}
		return count;
	}
}
