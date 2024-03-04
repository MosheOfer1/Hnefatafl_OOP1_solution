import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Position {
    private final int x;
    private final int y;
    private final List<Piece> pieces;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.pieces = new LinkedList<>();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPieceSize() {
        return new HashSet<>(pieces).size();
    }

    public void raisePiece(Piece piece) {
        pieces.add(piece);
    }

    public String piecesStr() {
        return getPieceSize() + " pieces";
    }

    @Override
    public String toString() {
        return "(" + x +
                ", " + y +
                ')';
    }

    public void erasePiece(Piece piece) {
        pieces.remove(piece);
    }
}
