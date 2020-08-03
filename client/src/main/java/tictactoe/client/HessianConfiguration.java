package tictactoe.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import tictactoe.GameApi;

@Configuration
public class HessianConfiguration {

    @Bean
    public HessianProxyFactoryBean hessianInvoker() {
        HessianProxyFactoryBean invoker = new HessianProxyFactoryBean();
        invoker.setServiceUrl("http://localhost:9600/game");
        invoker.setServiceInterface(GameApi.class);
        return invoker;
    }

}
