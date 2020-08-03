package tictactoe.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.remoting.support.RemoteExporter;
import tictactoe.GameApi;
import tictactoe.GameFlow;
import tictactoe.Player;

@SpringBootApplication
public class Server implements CommandLineRunner {

    private final GameApi game;

    @Autowired
    public Server(RemoteExporter game) {
        this.game = (GameApi) game.getService();
    }

    @Override
    public void run(String... args) throws Exception {
        new GameFlow(game, Player.X).flow();
        System.exit(0);
    }

    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }

}
