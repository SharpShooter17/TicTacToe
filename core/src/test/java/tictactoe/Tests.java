package tictactoe;

import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void test01() {
        GameLogic gameLogic = new GameLogic();
        gameLogic.mark(new Coordinates('A', 1));
        gameLogic.mark(new Coordinates('A', 2));
        gameLogic.mark(new Coordinates('A', 3));
        assertion(gameLogic.checkWinner());
    }

    @Test
    public void test02() {
        GameLogic gameLogic = new GameLogic();
        gameLogic.mark(new Coordinates('B', 1));
        gameLogic.mark(new Coordinates('B', 2));
        gameLogic.mark(new Coordinates('B', 3));
        assertion(gameLogic.checkWinner());
    }

    @Test
    public void test03() {
        GameLogic gameLogic = new GameLogic();
        gameLogic.mark(new Coordinates('C', 1));
        gameLogic.mark(new Coordinates('C', 2));
        gameLogic.mark(new Coordinates('C', 3));
        assertion(gameLogic.checkWinner());
    }

    @Test
    public void test04() {
        GameLogic gameLogic = new GameLogic();
        gameLogic.mark(new Coordinates('A', 1));
        gameLogic.mark(new Coordinates('B', 1));
        gameLogic.mark(new Coordinates('C', 1));
        assertion(gameLogic.checkWinner());
    }

    @Test
    public void test05() {
        GameLogic gameLogic = new GameLogic();
        gameLogic.mark(new Coordinates('A', 2));
        gameLogic.mark(new Coordinates('B', 2));
        gameLogic.mark(new Coordinates('C', 2));
        assertion(gameLogic.checkWinner());
    }

    @Test
    public void test06() {
        GameLogic gameLogic = new GameLogic();
        gameLogic.mark(new Coordinates('A', 3));
        gameLogic.mark(new Coordinates('B', 3));
        gameLogic.mark(new Coordinates('C', 3));
        assertion(gameLogic.checkWinner());
    }

    @Test
    public void test07() {
        GameLogic gameLogic = new GameLogic();
        gameLogic.mark(new Coordinates('A', 1));
        gameLogic.mark(new Coordinates('B', 2));
        gameLogic.mark(new Coordinates('C', 3));
        assertion(gameLogic.checkWinner());
    }

    @Test
    public void test08() {
        GameLogic gameLogic = new GameLogic();
        gameLogic.mark(new Coordinates('A', 3));
        gameLogic.mark(new Coordinates('B', 2));
        gameLogic.mark(new Coordinates('C', 1));
        assertion(gameLogic.checkWinner());
    }

    @Test
    public void test09() {
        GameLogic gameLogic = new GameLogic();
        gameLogic.mark(new Coordinates('A', 1));
        gameLogic.mark(new Coordinates('B', 2));
        gameLogic.mark(new Coordinates('C', 1));
        gameLogic.mark(new Coordinates('C', 2));
        gameLogic.mark(new Coordinates('B', 3));
        assertion(!gameLogic.checkWinner());
    }

    @Test
    public void test10() {
        GameLogic gameLogic = new GameLogic();
        gameLogic.mark(new Coordinates('A', 1));
        gameLogic.mark(new Coordinates('A', 2));
        gameLogic.changePlayer();
        gameLogic.mark(new Coordinates('A', 3));
        assertion(!gameLogic.checkWinner());
    }

    public void assertion(boolean shouldBeTrue) {
        if (!shouldBeTrue) {
            throw new IllegalStateException();
        }
    }

}
