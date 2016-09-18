import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Initials {
	
	public String getInitials(String name) {
		String[] x = name.split(" ");
		StringBuilder sb = new StringBuilder(x.length);
		for (String y : x) {
			sb.append(y.charAt(0));
		}
		return sb.toString();
	}
}
