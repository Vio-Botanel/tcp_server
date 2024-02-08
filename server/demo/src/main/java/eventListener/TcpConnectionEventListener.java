package eventListener;

import org.springframework.context.ApplicationListener;
import org.springframework.integration.ip.tcp.connection.TcpConnectionEvent;
import org.springframework.integration.ip.tcp.connection.TcpConnectionOpenEvent;
import org.springframework.stereotype.Component;

@Component
public class TcpConnectionEventListener implements ApplicationListener<TcpConnectionOpenEvent> {

    @Override
    public void onApplicationEvent(TcpConnectionOpenEvent event) {
    	System.out.print("asdasdasd");
    }
}
