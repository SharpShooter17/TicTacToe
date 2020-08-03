package tictactoe.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.support.RemoteExporter;
import tictactoe.GameApi;
import tictactoe.GameLogic;

@Configuration
public class HessianConfiguration {

    @Bean(name = "/game")
    public RemoteExporter gameService() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        GameApi api = new GameLogic();
        exporter.setService(api);
        exporter.setServiceInterface(GameApi.class);
        return exporter;
    }

}
