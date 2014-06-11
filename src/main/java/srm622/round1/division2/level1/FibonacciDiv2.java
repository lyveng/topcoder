package srm622.round1.division2.level1;

public class FibonacciDiv2 {
  public int find(int N) {
    int a = 0, b = 1, c;
    do {
      c = a + b;
      a = b;
      b = c;
    } while (c < N);
    System.out.println(a + " " + c);
    if ((N - a) < (c - N))
      return N - a;
    else
      return c - N;
  }

  public static void main(String[] args) {
    FibonacciDiv2 obj = new FibonacciDiv2();
    System.out.println(obj.find(1));
    System.out.println(obj.find(13));
    System.out.println(obj.find(14));
    System.out.println(obj.find(19));
    System.out.println(obj.find(1000000));

  }

}
