package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.ip.tcp.TcpInboundGateway;
import org.springframework.integration.ip.tcp.TcpOutboundGateway;
import org.springframework.integration.ip.tcp.TcpReceivingChannelAdapter;
import org.springframework.integration.ip.tcp.connection.AbstractServerConnectionFactory;
import org.springframework.integration.ip.tcp.connection.TcpNioServerConnectionFactory;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.service.IMessageServiceServer;

//import authentication.IAuthentificator;
import eventListener.TcpConnectionEventListener;

@Configuration
public class TcpServerConfig {

	@Value("${tcp.server.port}")
	private int port;

	@Bean
	public AbstractServerConnectionFactory serverConnectionFactory() {
		TcpNioServerConnectionFactory serverConnectionFactory = new TcpNioServerConnectionFactory(port);
		serverConnectionFactory.setUsingDirectBuffers(true);
		return serverConnectionFactory;
	}

	@Bean
	public MessageChannel inboundChannel() {
		return new DirectChannel();
	}

//	@Bean
//	public TcpConnectionEventListener tcpConnectionEventListener() {
//		return new TcpConnectionEventListener();
//	}

//	@Bean
//	  public TcpOutboundGateway tcpOutboundGateway() {
//        TcpOutboundGateway gateway = new TcpOutboundGateway();
//        gateway.setConnectionFactory(null);;
//        return gateway;
//    }

	@Bean
	public TcpInboundGateway inboundGateway(AbstractServerConnectionFactory serverConnectionFactory,
			MessageChannel inboundChannel) {
		TcpInboundGateway tcpInboundGateway = new TcpInboundGateway();
		tcpInboundGateway.setConnectionFactory(serverConnectionFactory);
		tcpInboundGateway.setRequestChannel(inboundChannel);
		return tcpInboundGateway;
	}

//	@Bean
//	public TextEncryptor textEncryptor() {
//		// Ensure that the hex-encoded strings have an even number of characters
//		String password = "your-password"; // Replace with a hex-encoded password
//		String salt = "your-salt"; // Replace with a hex-encoded salt
//
//		// If the hex-encoded strings have an odd number of characters, you might need
//		// to pad them
//		if (password.length() % 2 != 0) {
//			password = "0" + password;
//		}
//
//		if (salt.length() % 2 != 0) {
//			salt = "0" + salt;
//		}
//
//		return Encryptors.text(password, salt);
//	}

}
