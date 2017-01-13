import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ThePalindrome {
	private boolean isPalin(String s, int start, int end) {
		for (int i=start,j=end;i<j;i++,j--) {
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}
	
	public int find(String s) {
		if (isPalin(s, 0, s.length()-1))
			return s.length();
		for (int appendLength=1;appendLength <s.length();appendLength++) {
			if (isPalin(s, appendLength, s.length()-1))
				return s.length()+appendLength;
		}
		return 0;
	}
}
