/**
 * Created by per-joelsompio on 20/04/16.
 */
import java.util.ArrayList;
import java.io.Reader;
import java.io.IOException;


public class Maze {
    private char[][] mazeData;
    private Position start;

    public Maze(Reader reader) throws InvalidMazeException {
        ArrayList<String> rows = new ArrayList<>();
        try{
            int numStart = 0;
            int numGoal = 0;
            int readChar;
            String temp = "";

            while((readChar = reader.read()) != -1) {
                if(readChar == 'S') {
                    numStart++;
                    start =  new Position(temp.length(), rows.size());
                }
                if(readChar == 'G') {
                    numGoal++;
                }
                if(readChar == '\n') {
                    rows.add(temp);
                    temp = "";
                }
                else {
                    temp = temp + (char) readChar;
                }
            }

            if(temp.length() > 0) {
                rows.add(temp);
            }

            if(numStart != 1 || numGoal != 1) {
                throw new InvalidMazeException("Invalid, Maze must contain 1 start position" +
                        "and 1 goal position");
            }

            mazeData = new char[rows.size()][];
            for(int i = 0; i < rows.size(); i++) {
                mazeData[i] = rows.get(i).toCharArray();
            }

            }
            catch (IOException e) {
                 e.printStackTrace();

        }
    }

    public boolean isMoveable(Position pos) {
        if(mazeData[pos.getY()][pos.getX()] != ' ' ||
                mazeData[pos.getY()][pos.getX()] != 'G' ||
                mazeData[pos.getY()][pos.getX()] != 'S') {
            return false;
        }
        return true;
    }

    public boolean isGoal(Position pos) {
        if(mazeData[pos.getY()][pos.getX()] != 'G') {
            return false;
        }
        return true;
    }

    public Position getStartPosition() {
        return start;
    }

    public boolean isWithinMaze(Position pos) {
        if(pos.getY() < 0 || pos.getY() > mazeData.length
                || pos.getX() < 0 || pos.getX() > mazeData[pos.getY()].length()) {
            return false;
        }
        return true;
    }

}
