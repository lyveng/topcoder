import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class BearCheats {
	
	public String eyesight(int A, int B) {
		String a = Integer.toString(A), b = Integer.toString(B);
		if (a.length() != b.length())
			return "glasses";
		int diffCount = 0;
		for (int i=0;i<a.length();i++) {
			if (a.charAt(i) != b.charAt(i))
				diffCount++;
			if (diffCount > 1)
				return "glasses";
		}
		return "happy";
	}
}
