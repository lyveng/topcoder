import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Cyclemin {
	
	public String bestmod(String s, int k) {
		String best = s;
		char[] cur = s.toCharArray();
		for (int i=0;i<s.length();i++) {
			for (int j=0,a=k;j<s.length()&&a>0;j++) {
				if (cur[j] == 'a')
					continue;
				cur[j] = 'a';
				a--;
			}
			for (int j=0;j<cur.length;j++) {
				if (cur[j] < best.charAt(j)) {
					best = new String(cur);
					break;
				} else if (cur[j] == best.charAt(j))
					continue;
				else
					break;
			}
			for (int j=0;j<s.length();j++) {
				cur[j] = s.charAt((j+i+1) % s.length());
			}
		}
		return best;
	}
}
