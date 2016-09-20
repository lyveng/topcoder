import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class SimilarUserDetection {
	
	public String haveSimilar(String[] handles) {
		for (int i=0;i<handles.length;i++) {
			for (int j=i+1;j<handles.length;j++) {
				String a = handles[i], b = handles[j];
				if (a.length() != b.length())
					continue;
				boolean similar = true;
				for (int p=0;p<a.length();p++) {
					if (a.charAt(p) == b.charAt(p))
						continue;
					else if ((a.charAt(p) == 'O' || a.charAt(p) == '0') && (b.charAt(p) == 'O' || b.charAt(p) == '0')
						|| (a.charAt(p) == '1' || a.charAt(p) == 'l' || a.charAt(p) == 'I') && (b.charAt(p) == '1' || b.charAt(p) == 'l' || b.charAt(p) == 'I'))
						continue;
					else {
						similar = false;
						break;
					}
				}
				if (similar) {
					return "Similar handles found";
				}
			}
		}
		return "Similar handles not found";
	}
}
