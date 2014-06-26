package srm148.division2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Level 3 problem
 * 
 * @author emmanuel
 *
 */
public class MNS {
  private Set<MagicSquare> magicSquares;
  public int combos(int[] numbers) {
    magicSquares = new HashSet<MNS.MagicSquare>();
    combosUtil(numbers, 0);
    return magicSquares.size();
  }

  private void combosUtil(int[] numbers, int pos) {
    if (pos == numbers.length) {
      MagicSquare ms = new MagicSquare(Arrays.copyOf(numbers, numbers.length));
      if (!magicSquares.contains(ms) && isMagicSquare(numbers))
        magicSquares.add(ms);
      return;
    }
    for (int i=pos;i<numbers.length;i++) {
      swap(numbers, pos, i);
      combosUtil(numbers, pos+1);
      swap(numbers, pos, i);
    }
  }

  private boolean isMagicSquare(int[] numbers) {
    int sum = numbers[0] + numbers[1] + numbers[2];
    // check rows
    for (int i=0;i+3<numbers.length;i+=3)
      if (sum != numbers[i] + numbers[i+1] + numbers[i+2])
        return false;
    // check columns
    for (int i=0;i<3;i++)
      if (sum != numbers[i] + numbers[i+3] + numbers[i+6])
        return false;
    return true;
  }

  private void swap(int[] numbers, int i, int j) {
    int tmp = numbers[i];
    numbers[i] = numbers[j];
    numbers[j] = tmp;
  }

  private static class MagicSquare {
    int[] numbers;

    public MagicSquare(int[] numbers) {
      super();
      this.numbers = numbers;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + Arrays.hashCode(numbers);
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      MagicSquare other = (MagicSquare) obj;
      if (!Arrays.equals(numbers, other.numbers))
        return false;
      return true;
    }
    
  }
  public static void main(String[] args) {
    Set<MagicSquare> set = new HashSet<MagicSquare>();
    set.add(new MagicSquare(new int[] {1,2,3}));
    System.out.println(set.contains(new MagicSquare(new int[] {1,2,3})));
    System.out.println(set.contains(new MagicSquare(new int[] {1,2,4})));
  }
}
