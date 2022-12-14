import agh.ics.oop.*;
import agh.ics.oop.Observers.IPositionChangeObserver;
import agh.ics.oop.Tools.OptionsParser;
import agh.ics.oop.WorldMaps.AbstractWorldMap;
import agh.ics.oop.WorldMaps.IWorldMap;
import agh.ics.oop.WorldMaps.RectangularMap;
import agh.ics.oop.Tools.IEngine;
import agh.ics.oop.Tools.SimulationEngine;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WorldTest
{
    @Test
    public void StackTest() {
        String[] args = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,2), new Vector2d(2,2), new Vector2d(3,4) ,new Vector2d(2,2), new Vector2d(3,4) ,new Vector2d(2,2), new Vector2d(3,4)  };
        Vector2d[] finalPositions = {new Vector2d(2,0), new Vector2d(3,5) };
        ArrayList<IPositionChangeObserver> observers = new ArrayList<>();
        observers.add(map);


        assertTrue(TestMap(directions,map,positions,finalPositions, observers));
    }

    @Test
    public void MapRangesTest() {
        String[] args = {"r","f","f","f","f","f","f","f","f","f","f","f","f","l","f","f","f","f","f","f","l","f","f","f","f","f","f","f","f","f","f","f","f","l","f","f","f","f","f","f",};
        MoveDirection[] directions = new OptionsParser().parse(args);
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(0,0)};
        Vector2d[] finalPositions = {new Vector2d(0,0) };
        ArrayList<IPositionChangeObserver> observers = new ArrayList<>();
        observers.add(map);

        assertTrue(TestMap(directions,map,positions,finalPositions, observers));
    }

    @Test
    public void StackPlaceTest() {
        String[] args = {"f","b","b","f","r","r","l","l","f","f","f","f","l","r","l","r","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        RectangularMap map = new RectangularMap(10, 10);
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(0,1), new Vector2d(10,10), new Vector2d(10,9)};
        Vector2d[] finalPositions = { new Vector2d(1,0), new Vector2d(1,1), new Vector2d(9,10), new Vector2d(9,9)};
        ArrayList<IPositionChangeObserver> observers = new ArrayList<>();
        observers.add(map);

        assertTrue(TestMap(directions,map,positions,finalPositions, observers));
    }

    @Test
    public void OverallTest() {
        String[] args = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) , new Vector2d(2,2), new Vector2d(3,4) };
        Vector2d[] finalPositions = {new Vector2d(2,0), new Vector2d(3,5) };
        ArrayList<IPositionChangeObserver> observers = new ArrayList<>();
        observers.add(map);

        assertTrue(TestMap(directions,map,positions,finalPositions, observers));
    }

    @Test
    public void OverallTest2() {
        String[] args = {"r","r","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","l","l","f","f","f","f","f","f","f","f","f","f","f","f",};
        MoveDirection[] directions = new OptionsParser().parse(args);
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(2,2) };
        Vector2d[] finalPositions = {new Vector2d(10,5), new Vector2d(10,4) };
        ArrayList<IPositionChangeObserver> observers = new ArrayList<>();
        observers.add(map);

        assertTrue(TestMap(directions,map,positions,finalPositions, observers));
    }

    private boolean TestMap(MoveDirection[] directions, AbstractWorldMap map, Vector2d[] startingPositions, Vector2d[] finalOccupiedPositions, ArrayList<IPositionChangeObserver> observers) {
        IEngine engine = new SimulationEngine(directions, map, startingPositions, observers);
        engine.run();
        out.println(map.toString());

        for(Vector2d finishing : finalOccupiedPositions)
            if(!map.isOccupied(finishing))
                return false;

        return true;
    }

}