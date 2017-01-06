import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CirclesCountry {
	
	public int leastBorders(int[] X, int[] Y, int[] R, int x1, int y1, int x2, int y2) {
		List<Circle> p1 = new ArrayList<>(), p2 = new ArrayList<>();
		for (int i=0;i<X.length;i++) {
			if (dist(X[i], Y[i], x1, y1) < R[i]) {
				p1.add(new Circle(X[i], Y[i], R[i]));
			}
			if (dist(X[i], Y[i], x2, y2) < R[i]) {
				p2.add(new Circle(X[i], Y[i], R[i]));
			}
		}
		Collections.sort(p1);
		Collections.sort(p2);
		int i = 0;
		while (i < p1.size() &&  i < p2.size() && p1.get(i).equals(p2.get(i)))
			i++;
		return p1.size() + p2.size() - 2 * i;
	}

	private double dist(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
	}

	public class Circle implements Comparable<Circle> {
		int x, y, r;

		public Circle(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}

		@Override
		public int compareTo(Circle o) {
			return o.r - this.r;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Circle circle = (Circle) o;

			if (x != circle.x) return false;
			if (y != circle.y) return false;
			return r == circle.r;

		}

		@Override
		public int hashCode() {
			int result = x;
			result = 31 * result + y;
			result = 31 * result + r;
			return result;
		}
	}
}
