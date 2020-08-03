package tictactoe;

public enum Player {

    X("X"),
    O("O");

    public final String value;

    Player(String player) {
        this.value = player;
    }
}
