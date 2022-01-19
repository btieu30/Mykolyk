public class Gamer extends Player {

  private int _wins;
  private int _losses;

  public Gamer() {
    _wins = 0;
    _losses = 0;
  }

  public String stats() {\
    return "Wins:Losses = " + _wins + ":" + _losses;
  }

}
