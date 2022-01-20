public class Gamer extends Player {

  private int _wins;
  private int _losses;
  private String _name;

  public Gamer() {
    _wins = 0;
    _losses = 0;
    _name = "Gamer";
  }

  public Gamer(String tag, String newColor) {
    Gamer();
    _name = tag;
    _color = newColor;
  }

  public String name() {
    return _name;
  }

  public String stats() {\
    return "Wins:Losses = " + _wins + ":" + _losses;
  }

}
