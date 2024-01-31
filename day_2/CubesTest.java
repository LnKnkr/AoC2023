import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CubesTest {

  public static ArrayList<String> TaskOneInput = new ArrayList<>();

  @BeforeAll
  public static void Setup() {
    Path p = Paths.get("");
    try {
      Scanner sc = new Scanner(p.resolve("day_2").resolve("input.txt"));
      while (sc.hasNext()) {
        TaskOneInput.add(sc.nextLine());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void TestPartOne() {
    String[] got = {"Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
      "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
      "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
      "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
      "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green",
      };
    Cubes c = new Cubes(got);
    Assertions.assertEquals(8, c.validateGame(14, 12, 13));
  }

  @Test
  public void TestTaskOne() {
    Cubes c = new Cubes(TaskOneInput.toArray(new String[0]));
    System.out.println("Day 2 Task 1: " + c.validateGame(14, 12, 13));
  }

  @Test
  public void TestPartTwo() {
    String[] got = {"Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
      "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
      "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
      "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
      "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green",
    };
    Cubes c = new Cubes(got);
    Assertions.assertEquals(2286, c.powerSum());
  }

  @Test
  public void TestTaskTwo() {
    Cubes c = new Cubes(TaskOneInput.toArray(new String[0]));
    System.out.println("Day 2 Task 2: " + c.powerSum());
  }
}
