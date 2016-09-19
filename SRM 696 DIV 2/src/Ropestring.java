import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Ropestring {
	
	public String makerope(String s) {
		int dots = 0;
		Map<Integer, Integer> dashes = new HashMap<>();
		int dashCount = 0;
		for (char c : s.toCharArray()) {
			if(c == '.') {
				dots++;
				if (dashCount != 0) {
					if (!dashes.containsKey(dashCount)) {
						dashes.put(dashCount, 0);
					}
					dashes.put(dashCount, dashes.get(dashCount) + 1);
				}
				dashCount = 0;
			}
			else {
				dashCount++;
			}
		}
		if (dashCount != 0) {
			if (!dashes.containsKey(dashCount)) {
				dashes.put(dashCount, 0);
			}
			dashes.put(dashCount, dashes.get(dashCount) + 1);
		}
		StringBuilder sb = new StringBuilder(s.length());
		int dotCount = 0;
		Integer[] dashKeys = dashes.keySet().toArray(new Integer[]{});
		Arrays.sort(dashKeys, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		for (int dashLength : dashKeys) {
			if (dashLength % 2 == 0) {
				for (int j=0;j<dashes.get(dashLength);j++) {
					for (int i = 0; i < dashLength; i++) {
						sb.append('-');
					}
					sb.append('.');
					dotCount++;
				}
			}
		}
		for (int dashLength : dashKeys) {
			if (dashLength % 2 != 0) {
				for (int j=0;j<dashes.get(dashLength);j++) {
					for (int i = 0; i < dashLength; i++) {
						sb.append('-');
					}
					sb.append('.');
					dotCount++;
				}
			}
		}
		while (dotCount < dots) {
			sb.append('.');
			dotCount++;
		}
		if (dotCount > dots) {
			sb.deleteCharAt(sb.length() - 1);
		}
//		assert sb.toString().length() == s.length();
		return sb.toString();
	}
}
