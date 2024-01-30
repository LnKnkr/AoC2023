import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class TrebuchetTest {

  public static ArrayList<String> TaskTwoInput = new ArrayList<>();

  @BeforeAll
  public static void Setup() {
    Path p = Paths.get("");
    try {
      Scanner sc = new Scanner(p.resolve("day_1").resolve("input.txt"));
      while (sc.hasNext()) {
        TaskTwoInput.add(sc.nextLine());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void TestExampleBuilds() {
    String input = "";
    int want = 0;
    Assertions.assertEquals(want, Trebuchet.calc(input));
  }

  @Test
  public void TestTaskOne() {
    String[] input = {"1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet"};
    int[] want = {12, 38, 15, 77};

    for (int i = 0; i < input.length; i++) {
      Assertions.assertEquals(want[i], Trebuchet.calc(input[i]));
    }
  }

  @Test
  public void TestSumOne() {
    String[] input = {"1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet"};
    Assertions.assertEquals(142, Trebuchet.sum(input));
  }

  @Test
  public void TestTaskTwo() {
    String[] input = {"two1nine",
      "eightwothree",
      "abcone2threexyz",
      "xtwone3four",
      "4nineeightseven2",
      "zoneight234",
      "7pqrstsixteen",
    "33rgcjxfsfqsvxxbxcnrjfndrrfmrtk",
    "zlmlk1",
    "5282gdnc918",
    "abc3dueueu3seven",
      "2sadkjfhaskldj"};
    int[] want = {29, 83, 13, 24, 42, 14, 76, 33, 11, 58, 37,22};
    for (int i = 0; i < input.length; i++) {
      Assertions.assertEquals(want[i], Trebuchet.calc(input[i]));
    }
  }

  @Test
  public void TestSumTwo() {
    String[] input = {"two1nine",
      "eightwothree",
      "abcone2threexyz",
      "xtwone3four",
      "4nineeightseven2",
      "zoneight234",
      "7pqrstsixteen"};
    Assertions.assertEquals(281, Trebuchet.sum(input));
  }

  @Test
  public void TestTaskResult() {
    int result = Trebuchet.sum(TaskTwoInput.toArray(new String[0]));
    System.out.println(result);
  }
}
