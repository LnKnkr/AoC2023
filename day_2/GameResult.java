import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameResult {

  private static final Pattern gamePattern = Pattern.compile("Game ([0-9]*):");

  private static final Pattern bluePattern = Pattern.compile("([1-9][0-9]*?) blue");
  private static final Pattern redPattern = Pattern.compile("([1-9][0-9]*?) red");
  private static final Pattern greenPattern = Pattern.compile("([1-9][0-9]*?) green");

  public int ID;

  private ArrayList<PartialGame> partial;

  public GameResult(String in) {
    super();
    Matcher m = gamePattern.matcher(in);
    if(m.find()) {
      try {
        this.ID = Integer.parseInt(m.group(1));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }else{
      this.ID = -1;
    }
    this.partial = new ArrayList<>();
    String[] split = in.split("[:|;]");
    for(int i = 1; i < split.length; i++) {
      Matcher b = bluePattern.matcher(split[i]);
      int blue = b.find() ? Integer.parseInt(b.group(1)) : 0;
      Matcher r = redPattern.matcher(split[i]);
      int red = r.find() ? Integer.parseInt(r.group(1)) : 0;
      Matcher g = greenPattern.matcher(split[i]);
      int green = g.find() ? Integer.parseInt(g.group(1)) : 0;
      this.partial.add(new PartialGame(blue, red, green));
    }
  }

  public boolean isValid(int blue, int red, int green) {
    for (PartialGame p : this.partial) {
      if (!p.isValid(blue, red, green)) {
        return false;
      }
    }
    return true;
  }

  public int power() {
    int blue = 0;
    int red = 0;
    int green = 0;

    for (PartialGame p : this.partial) {
      if (blue == 0 || (blue < p.blue && p.blue != 0)) {
        blue = p.blue;
      }
      if (red == 0|| (red < p.red && p.red != 0)) {
        red = p.red;
      }
      if (green == 0|| (green < p.green && p.green != 0)) {
        green = p.green;
      }
    }
    return blue * red * green;
  }

}
