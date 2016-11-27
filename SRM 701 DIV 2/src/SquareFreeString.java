import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class SquareFreeString {
	
	public String isSquareFree(String s) {
		char[] t = s.toCharArray();
		for (int len=2;len<=t.length;len+=2) {
			for (int i=0;i<=t.length-len;i++) {
				int a=i,b=i+len/2;
				boolean c = true;
				while (a<(i+len/2)) {
					if (t[a] != t[b]) {
						c = false;
						break;
					}
					a++;
					b++;
				}
				if (c)
					return "not square-free";
			}
		}
		return "square-free";
	}
}
