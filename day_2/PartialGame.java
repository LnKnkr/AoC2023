public class PartialGame {

  public int red;

  public int green;

  public int blue;

  public PartialGame(int blue, int red, int green) {
    super();
    this.blue = blue;
    this.red = red;
    this.green = green;
  }

  public boolean isValid(int blue, int red, int green) {
    return this.green <= green && this.blue <= blue && this.red <= red;
  }


}
