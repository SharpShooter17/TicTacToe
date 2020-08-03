package tictactoe;

import java.io.Serializable;

public class Coordinates implements Serializable {

    private static final long serialVersionUID = -2129273852412081547L;

    public final char x;
    public final int y;

    public Coordinates(char x, int y) {
        this.x = x;
        this.y = y;
        validateCoordinate(x - 'A' + 1);
        validateCoordinate(y);
    }

    private void validateCoordinate(int c) {
        if (c < 1 || c > 3) {
            throw new IllegalStateException("Coordinates should be between 1 and 3!");
        }
    }
}
