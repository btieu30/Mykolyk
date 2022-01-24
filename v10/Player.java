public class Player {

  protected String _letter;
  protected String _name;
  protected int _colorBg;

  public Player() {
    _letter = "";
    _colorBg = 30;
  }

  public String name() {
    return _name;
  }

  public void setLetter( String letter ) {
    _letter = letter;
  }

  public String letter() {
    return _letter;
  }

    public void setBg ( int newBg ) {
    _colorBg = newBg + 30;
  }

  public int Bg() {
    return _colorBg;
  }

}
