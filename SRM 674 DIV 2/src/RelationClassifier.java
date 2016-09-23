import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class RelationClassifier {
	boolean isB(int[] domain, int[] range) {
		boolean a= true;
		for (int i=0;i<domain.length;i++) {
			for (int j=0;j<range.length;j++) {
				if (i==j)
					continue;
				if (range[j] == range[i]) {
					a = false;
					break;
				}
			}
			if (!a)
				break;
		}
		return a;
	}
	
	public String isBijection(int[] domain, int[] range) {
		boolean a=isB(domain, range), b=isB(range, domain);
		if (a && b)
			return "Bijection";
		return "Not";
	}
}
