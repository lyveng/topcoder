import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Plusonegame {
	
	public String getorder(String s) {
		int[] count = new int[]{0,0,0,0,0,0,0,0,0,0};
		int plus = 0;
		for (char c : s.toCharArray()) {
			if (c == '+')
				plus++;
			else {
				count[c - '0']++;
			}
		}
		int ctr = 0, penalty = 0;
		StringBuilder sb = new StringBuilder(s.length());
		if (plus == 0) {
			char[] str = s.toCharArray();
			Arrays.sort(str);
			sb.append(str);
			return sb.toString();
		}
		for (int i=0;i<plus&&i<10;i++) {
			for (int j=0;j<count[i];j++) {
				sb.append((char)('0'+i));
				penalty += Math.abs(ctr - i);
			}
			count[i] = 0;
			sb.append('+');
			ctr++;
		}
		for (int i=0;i<count.length;i++) {
			for (int j=0;j<count[i];j++) {
				sb.append((char)('0' + i));
			}
		}
		for (int i=10;i<plus;i++)
			sb.append('+');
		return sb.toString();
	}
}
