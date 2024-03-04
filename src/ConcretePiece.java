import java.util.ArrayList;
import java.util.List;

/**
 * An abstract class for a single piece on the board
 * Don't make any changes here!
 */
public abstract class ConcretePiece implements Piece {
    protected Player owner;
    private final List<Position> positionsHistory = new ArrayList<>();
    protected int dist;
    protected int number;

    // Method to get the owner of the piece (defender or attacker)
    @Override
    public Player getOwner() {
        return owner;
    }

    // Method to update the piece, for new movement
    public void update(Position newPosition) {
        setNewPosition(newPosition);
    }

    public int getDist() {
        return dist == 0 ? calculateDist() : dist;
    }
    public String getDistStr() {
        return getDist() + " squares";
    }
    private int calculateDist() {
        for (int i = 0; i < positionsHistory.size() - 1; i++) {
            int x = positionsHistory.get(i).getX(), y = positionsHistory.get(i).getY();
            int x1 = positionsHistory.get(i+1).getX(), y1 = positionsHistory.get(i+1).getY();

            this.dist += Math.abs(x - x1) + Math.abs(y - y1);
        }
        return dist;
    }
    public List<Position> getPositionHistory() {
        return positionsHistory;
    }
    public Position getLastPosition() {
        return positionsHistory.get(positionsHistory.size() - 1);
    }
    public void setNewPosition(Position position) {
        positionsHistory.add(position);
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    @Override
    abstract public String getType();

    @Override
    abstract public String toString();

    public void deleteLastStep() {
        positionsHistory.remove(positionsHistory.size()-1);
    }
}
