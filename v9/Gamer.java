public class Gamer extends Player {

  private int _wins;
  private int _losses;

  public Gamer() {
    _wins = 0;
    _losses = 0;
    _name = "Gamer";
  }

  public Gamer(String tag, String newLetter) {
    this();
    _name = tag;
    _letter = newLetter;
  }

  public int wins() {
    return _wins;
  }

  public int losses() {
    return _losses;
  }

}
