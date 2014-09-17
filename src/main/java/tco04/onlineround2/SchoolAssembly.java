package tco04.onlineround2;
/**
 * Level1 problem.
 * 
 * @author emmanuel
 *
 */
public class SchoolAssembly {

  public int getBeans(int kids, int quantity) {
    int beans = (quantity - 1) * 5 + (kids - 1) * quantity + 1;
    int ret = beans / 20;
    if (beans % 20 != 0)
      ret++;
    return ret;
  }

}
