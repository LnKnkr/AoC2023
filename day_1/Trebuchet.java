import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Trebuchet {

  private static final Pattern p = Pattern.compile("(one|two|three|four|five|six|seven|eight|nine)");

  private static String transformNumber(String in) {
    return in.replace("one", "1").replace("two", "2").replace("three", "3").replace("four", "4").replace("five", "5").replace("six", "6").replace("seven", "7").replace("eight", "8").replace("nine", "9").replace("zero", "0");
  }

  public static int calc(String in) {
    if (in.length() == 0) {
      return 0;
    }
    String firstNumber = "[1-9]";
    String otherNumber = "[0-9]";

    String result = "";

    String[] split = in.split("");
    String runner = "";
    for (String s : split) {
      Matcher cur = p.matcher(runner);
      if (cur.find()) {
        result = cur.group(1);
        break;
      }
      if (s.matches(firstNumber)) {
        result = s;
        break;
      } else {
        runner = runner + s;
      }
    }

    runner = "";
    result = Trebuchet.transformNumber(result);

    for (int i = split.length - 1; i >= 0; i--) {
      Matcher cur = p.matcher(runner);
      if (cur.find()) {
        result = result + cur.group(1);
        break;
      }
      if (split[i].matches(otherNumber)) {
        result = result + split[i];
        break;
      }else{
        runner = split[i] + runner;
      }
    }

    return Integer.parseInt(Trebuchet.transformNumber(result));
  }

  public static int sum(String[] in) {
    int sum = 0;

    for (String s : in) {
      int current = Trebuchet.calc(s);
//      System.out.println(s + "  :  " + current);
      sum += current;
    }

    return sum;
  }

}
