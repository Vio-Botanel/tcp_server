package com.example.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import com.example.demo.service.impl.MessageServiceServerImpl;

@MessageEndpoint
public class TcpServerEndpoint {
	private MessageServiceServerImpl messageService;

    @Autowired
    public TcpServerEndpoint(MessageServiceServerImpl messageService) {
        this.messageService = messageService;
    }

    @ServiceActivator(inputChannel = "inboundChannel")
    public byte[] process(byte[] message) {
        return messageService.processMessage(message);
    }
}
