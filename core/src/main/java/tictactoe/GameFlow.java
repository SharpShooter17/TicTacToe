package tictactoe;

import java.util.Scanner;

public class GameFlow {

    private final GameApi api;
    private final Player playerType;
    private final Scanner in;

    public GameFlow(GameApi api,
                    Player playerType) {
        this.api = api;
        this.playerType = playerType;
        this.in = new Scanner(System.in);
    }

    public void flow() {
        while (!api.isEndOfGame()) {
            if (api.currentPlayer().equals(playerType)) {
                do {
                    System.out.println(api.boardToString());
                    System.out.print("> ");
                } while (!api.mark(new Coordinates(in.next().charAt(0), in.nextInt())));
                if (!api.checkWinner()) {
                    api.changePlayer();
                }
            } else {
                Thread.yield();
            }
        }
        System.out.println(api.boardToString());
        System.out.println("Winner is: " + api.currentPlayer());
    }
}
