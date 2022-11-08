
import agh.ics.oop.Animal;
import agh.ics.oop.MapDirection;
import agh.ics.oop.MoveDirection;
import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    @Test

    public void MoveTest() {

        AnimalTestModel[] tests = new AnimalTestModel[]{
                new AnimalTestModel(
                        new Vector2d(0, 0),
                        new String[]{"b", "b", "b", "r", "b", "b", "b"},
                        new Animal(),
                        MapDirection.EAST),
                new AnimalTestModel(
                        new Vector2d(0, 0),
                        new String[]{"l", "f", "f", "f", "r", "b", "b", "b", "z", "s", "x", "g", "X"},
                        new Animal(),
                        MapDirection.NORTH),
                new AnimalTestModel(
                        new Vector2d(2, 2),
                        new String[]{"b", "b", "b", "r", "b", "b", "b", "r", "b", "b", "r", "b", "b", "r"},
                        new Animal(),
                        MapDirection.NORTH),
                new AnimalTestModel(
                        new Vector2d(4, 4),
                        new String[]{"f", "f", "f", "r", "f", "f", "b", "f", "f"},
                        new Animal(),
                        MapDirection.EAST),
                new AnimalTestModel(
                        new Vector2d(4, 4),
                        new String[]{"f", "f", "f", "r", "f", "f", "b", "f", "f", "l", "l", "l"},
                        new Animal(),
                        MapDirection.SOUTH),
                new AnimalTestModel(
                        new Vector2d(3, 4),
                        new String[]{"f", "f", "f", "r", "f", "f", "b", "f", "f", "l", "l", "l", "r", "f", "l"},
                        new Animal(),
                        MapDirection.SOUTH)
        };

        for (AnimalTestModel test : tests) {
            test._animal.move2(test._directions);
            assertEquals(test._validAnswer, test._animal.getPos());
        }
    }
}
