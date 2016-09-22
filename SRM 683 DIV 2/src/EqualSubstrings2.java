import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class EqualSubstrings2 {
	
	public int get(String s) {
		int s1, s2, count=0;
		boolean match;
		for (int length = 1; length < s.length(); length++) {
			for (s1=0;s1+length <= s.length();s1++) {
				for (s2=s1+length;s2+length <= s.length(); s2++) {
					match = true;
					for (int i=0;i<length;i++) {
						if (s.charAt(s1+i) != s.charAt(s2+i)) {
							match = false;
							break;
						}
					}
					if (match)
						count++;
				}
			}
		}
		return count;
	}
}
