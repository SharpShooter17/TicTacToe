package tictactoe;

public interface GameApi {

    boolean mark(Coordinates coordinates);

    boolean checkWinner();

    boolean isEndOfGame();

    void changePlayer();

    Player currentPlayer();

    String boardToString();

}
