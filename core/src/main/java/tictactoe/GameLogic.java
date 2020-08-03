package tictactoe;

import java.util.Optional;

public class GameLogic implements GameApi {

    private final Player[][] board = new Player[3][3];

    private Player activePlayer = Player.X;

    private Player winner = null;

    @Override
    public boolean mark(Coordinates coordinates) {
        int x = coordinates.x - 'A';
        int y = coordinates.y - 1;
        if (board[x][y] == null) {
            board[x][y] = activePlayer;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkWinner() {
        boolean isWinner = isWinner();
        if (isWinner) {
            this.winner = activePlayer;
        }
        return isWinner;
    }

    private boolean isWinner() {
        for (Player[] boardLine : board) {
            if (hasHorizontalLine(boardLine)) {
                return true;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (hasVerticalLine(col)) {
                return true;
            }
        }

        return checkDiagonals();
    }

    private boolean checkDiagonals() {
        boolean firstDiagonal = activePlayer == board[0][0] && activePlayer == board[1][1] && activePlayer == board[2][2];
        return firstDiagonal || (activePlayer == board[2][0] && activePlayer == board[1][1] && activePlayer == board[0][2]);
    }

    private boolean hasVerticalLine(int col) {
        for (int row = 0; row < 3; row++) {
            if (board[row][col] != activePlayer) {
                return false;
            }
        }

        return true;
    }

    private boolean hasHorizontalLine(Player[] boardLine) {
        for (Player cell : boardLine) {
            if (cell != activePlayer) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEndOfGame() {
        if (this.winner != null) {
            return true;
        }

        for (Player[] boardLine : board) {
            for (Player cell : boardLine) {
                if (cell == null) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public void changePlayer() {
        activePlayer = Player.X == activePlayer ? Player.O : Player.X;
    }

    @Override
    public Player currentPlayer() {
        return activePlayer;
    }

    @Override
    public String boardToString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Active player: ").append(activePlayer.value).append('\n');
        builder.append(buildRow(0, 'A'));
        builder.append(buildRow(1, 'B'));
        builder.append(buildRow(2, 'C'));
        builder.append(1).append("|").append(2).append("|").append(3).append("|");
        return builder.toString();
    }

    private String buildRow(int row, char a) {
        Player[] boardLine = board[row];
        return cellToString(boardLine[0]) + cellToString(boardLine[1]) + cellToString(boardLine[2]) + a + '\n';
    }

    private String cellToString(Player cell) {
        return Optional.ofNullable(cell).map(p -> p.value).orElse(" ") + "|";
    }

    public Player winner() {
        return winner;
    }
}
