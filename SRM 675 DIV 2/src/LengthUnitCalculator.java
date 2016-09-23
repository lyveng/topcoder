import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class LengthUnitCalculator {
	int getPos(String unit) {
		switch (unit) {
			case "mi": return 0;
			case "yd": return 1;
			case "ft": return 2;
			case "in": return 3;
			default: return -1;
		}
	}
	
	public double calc(int amount, String fromUnit, String toUnit) {
		double[] conv = new double[] {1, 1760, 3, 12};
		int f = getPos(fromUnit), t = getPos(toUnit);
		double ret = amount;
		if (f == t) {
			return amount;
		} else if (f < t) {
			for (int i=f+1;i<=t;i++)
				ret *= conv[i];
		} else {
			for (int i=f;i>t;i--)
				ret /= conv[i];
		}
		return ret;
	}
}
