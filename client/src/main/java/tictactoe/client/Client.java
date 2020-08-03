package tictactoe.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import tictactoe.GameApi;
import tictactoe.GameFlow;
import tictactoe.Player;

@SpringBootApplication
public class Client implements CommandLineRunner {

    private final GameApi gameApi;

    public Client(HessianProxyFactoryBean gameProxy) {
        this.gameApi = (GameApi) gameProxy.getObject();
    }

    @Override
    public void run(String... args) throws Exception {
        new GameFlow(gameApi, Player.O).flow();
        System.exit(0);
    }

    public static void main(String[] args) {
        SpringApplication.run(Client.class, args);
    }
}
