/**
 * Created by per-joelsompio on 20/04/16.
 */

public abstract class Robot {
    private Position position;
    protected Maze maze;

    public Robot(Maze maze) {
        position = maze.getStartPosition();
        this.maze = maze;
    }

    public void move() {

    }

    public Position getCurrentPosition() {
        return this.position;
    }

    protected void setCurrentPosition(Position pos) {
        this.position = pos;
    }

    public boolean hasReachedGoal() {
        return maze.isGoal(position);
    }
}
