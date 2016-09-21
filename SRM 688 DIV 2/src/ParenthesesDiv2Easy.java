import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ParenthesesDiv2Easy {
	
	public int getDepth(String s) {
		return this.getDepth(s, 0, s.length()-1);
	}

	int getDepth(String s, int start, int end) {
		if (start > end)
			return 0;
		int pos = 0;
		for (int i=start; i<= end; i++) {
			if (s.charAt(i) == '(') {
				pos++;
			} else {
				pos--;
			}
			if (pos == 0) {
				return Math.max(1 + getDepth(s, start+1, i-1), getDepth(s, i+1, end));
			}
		}
		return 0;
	}
}
