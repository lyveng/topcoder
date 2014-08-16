package srm174.division1;
public class BirthdayOdds {

  public int minPeople(int minOdds, int daysInYear) {
    int peopleInRoom = 1;
    double odds = 1, prevOdds = 1, target = 1. - minOdds/100.;
    while (odds > target)
    {
      peopleInRoom++;
      prevOdds = odds;
      odds *= (daysInYear - peopleInRoom + 1.) / daysInYear;
    }
    return peopleInRoom;
  }

}
