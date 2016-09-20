import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class DoubleString {
	
	public String check(String S) {
		if (S.length() % 2 != 0)
			return "not square";
		for (int i=0,j=S.length()/2;i<S.length()/2;i++,j++) {
			if (S.charAt(i) != S.charAt(j)) {
				return "not square";
			}
		}
		return "square";
	}
}
