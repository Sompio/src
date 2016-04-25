/**
 * Created by per-joelsompio on 20/04/16.
 */
public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Position getPosToSouth() {
        Position southPos;
        southPos = new Position(getX(), getY()-1 );
        return southPos;

    }

    public Position getPosToNorth() {
        Position northPos;
        northPos = new Position(getX(), getY()+1 );
        return northPos;
    }

    public Position getPosToWest() {
        Position westPos;
        westPos = new Position(getX()-1, getY() );
        return westPos;
    }

    public Position getPosToEast() {
        Position eastPos;
        eastPos = new Position(getX()+1, getY() );
        return eastPos;
    }

    public boolean equals(Object o) {
        if(o instanceof Position) {

            Position pos = (Position)o;

            if(pos.x == x && pos.y == y) {

                return true;
            }
        }
        return false;

    }

    public int hashCode() {
        return (x + " " + y).hashCode();
    }
}
