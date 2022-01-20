public class Player {

  protected String _color;

  public Player() {
    _color = "B";
  }

  public void setColor( String newColor ) {
    _color = newColor;
  }

  public String color() {
    return _color;
  }

}
