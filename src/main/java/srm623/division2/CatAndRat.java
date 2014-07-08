package srm623.division2;

public class CatAndRat {
  public double getTime(int R, int T, int Vrat, int Vcat) {
    if (Vrat >= Vcat)
      return -1.0;
    double maxDistFromCat = Math.PI * R;
    double distFromCat = Math.min(maxDistFromCat, Vrat*T);
    return distFromCat / (Vcat - Vrat);
  }

  public static void main(String[] args) {
    CatAndRat obj = new CatAndRat();
    System.out.println(obj.getTime(10, 1, 1, 1));
    System.out.println(obj.getTime(10, 1, 1, 2));
    System.out.println(obj.getTime(10, 1, 2, 1));
    System.out.println(obj.getTime(1000, 1000, 1, 1000));
    System.out.println(obj.getTime(1, 1000, 1, 2));
    System.out.println();
  }

}
