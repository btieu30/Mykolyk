public class Gamer extends Player {

  private int _wins;
  private int _losses;
  protected int _colorBg;

  public Gamer() {
    _wins = 0;
    _losses = 0;
    _name = "Gamer";
    _colorBg = 30;
  }

  public Gamer(String tag, String newColor) {
    this();
    _name = tag;
    _color = newColor;
  }

  public String name() {
    return _name;
  }

  public String stats() {
    return "Wins:Losses = " + _wins + ":" + _losses;
  }

  public void setBg ( int newBg ) {
    _colorBg = newBg + 30;
  }

  public int Bg() {
    return _colorBg;
  }

}
