import java.util.ArrayList;

public class Cubes {

  private ArrayList<GameResult> games;
  public Cubes(String[] in) {
    this.games = new ArrayList<>();
    for (String s : in) {
      this.games.add(new GameResult(s));
    }
  }

  public int validateGame(int blue, int red, int green) {
    int result = 0;

    ArrayList<GameResult> success = new ArrayList<>();
    for(GameResult g: this.games) {
      if (g.isValid(blue, red, green)) {
        success.add(g);
      }
    }

    for(GameResult g: success) {
      result += g.ID;
    }

    return result;
  }

  public int powerSum() {
    int result =0;
    for(GameResult g: this.games) {
      result += g.power();
    }
    return result;
  }
}
