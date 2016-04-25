/**
 * Created by per-joelsompio on 22/04/16.
 */
public class RightHandRuleRobot extends Robot {
    private int orientation;


    public RightHandRuleRobot(Maze maze) {
        super(maze);
        orientation = 1; // 1 = north, 2 = west, 3 = south, 4 = east

    }

    public void move() {
        switch(orientation) {
            case 1: orientationNorth();
                break;
            case 2: orientationWest();
                break;
            case 3: orientationSouth();
                break;
            case 4: orientationEast();
                break;
            default: System.out.println("Error, no orientations given");
        }
    }

    /*hand on the east side of the wall*/
    public void orientationNorth() {
        if(maze.isMoveable(getCurrentPosition().getPosToNorth())) {
            setCurrentPosition(getCurrentPosition().getPosToNorth());
            orientation = 1;

        }
    }
    /*hand on north side of the wall*/
    public void orientationWest() {
        if(maze.isMoveable(getCurrentPosition().getPosToWest())) {
            setCurrentPosition(getCurrentPosition().getPosToWest());
            orientation = 2;
        }
    }
    //hand on west side of the walls
    public void orientationSouth() {
        if(maze.isMoveable(getCurrentPosition().getPosToSouth())) {
            setCurrentPosition(getCurrentPosition().getPosToSouth());
            orientation = 3;
        }
    }
    //hand on souh side of the walls
    public void orientationEast() {
        if(maze.isMoveable(getCurrentPosition().getPosToEast())) {
            setCurrentPosition(getCurrentPosition().getPosToWest());
            orientation = 4;
        }
    }
}
