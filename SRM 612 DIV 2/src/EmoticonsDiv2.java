import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class EmoticonsDiv2 {
	
	public int printSmiles(int smiles) {
		int[] arr = new int[smiles+1];
		for (int i=2;i<arr.length;i++)
			arr[i] = Integer.MAX_VALUE;
		arr[1] = 0;
		for (int i=1;i<=smiles/2;i++) {
			for (int j=1;i+j*i <= smiles;j++) {
				arr[i+j*i] = Math.min(arr[i+j*i], arr[i] + 1 + j);
			}
		}
		return arr[smiles];
	}
}
