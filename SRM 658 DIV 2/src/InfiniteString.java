import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class InfiniteString {
	public String find(String s, int length) {
		if (s.length() % length != 0 || s.length() == length)
			return s;
		for (int i=0;i<s.length();i+=length) {
			for (int j=i,k=0;j<i+length;j++,k++) {
				if (s.charAt(k) != s.charAt(j))
					return s;
			}
		}
		return s.substring(0,length);
	}
	
	public String equal(String s, String t) {
		int l = Math.min(s.length(), t.length());
		String[] sl = new String[l], tl = new String[l];
		for (int i=1;i<=l;i++) {
			sl[i-1] = this.find(s, i);
			tl[i-1] = this.find(t, i);
		}
		for (int i=0;i<sl.length;i++) {
			for (int j=0;j<tl.length;j++)
				if (sl[i].contentEquals(tl[j]))
					return "Equal";
		}
		return "Not equal";
	}
}
