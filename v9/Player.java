public class Player {

  protected String _color;
  protected String _name;

  public Player() {
    _color = "";
  }

  public void setColor( String newColor ) {
    _color = newColor;
  }

  public String color() {
    return _color;
  }

}
