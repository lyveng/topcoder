import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class DNASequence {
	
	public int longestDNASequence(String sequence) {
		int max = 0, cur = 0;
		for (int i=0;i<sequence.length();i++) {
			cur = 0;
			for (int j=i;j<sequence.length();j++) {
				char c = sequence.charAt(j);
				if (c == 'A' || c == 'C' || c == 'G' || c == 'T') {
					cur++;
					if (cur > max)
						max = cur;
				} else {
					cur = 0;
				}
			}
		}
		return max;
	}
}
