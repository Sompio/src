/**
 * Created by per-joelsompio on 22/04/16.
 */
import java.util.HashMap;
import java.util.Stack;

public class MemoryRobot extends Robot{
    private HashMap<Integer, Position> visited;
    private Stack<Position> backtrack;

    public MemoryRobot(Maze maze) {
        super(maze);
        visited = new HashMap<>();
        backtrack = new Stack<>();
    }

    public void move() {
        if(doMove(getCurrentPosition().getPosToSouth())) {
            setCurrentPosition(getCurrentPosition().getPosToSouth());
        }
        else if(doMove(getCurrentPosition().getPosToEast())) {
            setCurrentPosition(getCurrentPosition().getPosToEast());
        }
        else if(doMove(getCurrentPosition().getPosToNorth())) {
            setCurrentPosition(getCurrentPosition().getPosToNorth());
        }
        else if(doMove(getCurrentPosition().getPosToWest())) {
            setCurrentPosition(getCurrentPosition().getPosToWest());
        }

        if(backtrack.empty()) {
            System.out.println("no path could be found from start to finish");
            System.exit(-1);
        }
        //popping positions from the stack until a move can be made
        backtrack.pop();
        setCurrentPosition(backtrack.peek());
    }

    public boolean doMove(Position pos) {
        if(maze.isMoveable(pos)) {
            if(!visited.containsKey(pos.hashCode())) {
                visited.put(pos.hashCode(), pos);
                backtrack.push(pos);
                //setCurrentPosition(pos);
                return true;
            }
        }return false;
    }

}
