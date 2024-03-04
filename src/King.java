public class King extends ConcretePiece {
    public King(Player defender) {
        this.owner = defender;
        this.dist = 0;
    }

    @Override
    public String getType() {
        return "♔";
    }

    @Override
    public String toString() {
        return "K"  + number + ": ";
    }
}
