public class Gamer extends Player {

  private int _wins;
  private int _losses;

  public Gamer() {
    _wins = 0;
    _losses = 0;
    _name = "Gamer";
    _colorBg = 66;
  }

  public Gamer(String tag, String newLetter) {
    this();
    _name = tag;
    _letter = newLetter;
  }

  public String stats() {
    return "Wins:Losses = " + _wins + ":" + _losses;
  }

}
