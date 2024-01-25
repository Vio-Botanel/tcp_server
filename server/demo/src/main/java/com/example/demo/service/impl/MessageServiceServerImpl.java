package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.service.IMessageServiceServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MessageServiceServerImpl implements IMessageServiceServer {

	   private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceServerImpl.class);

	    @Override
	    public byte[] processMessage(byte[] message) {
	        String messageContent = new String(message);
	        LOGGER.info("Receive message: {}", messageContent);
	        String responseContent = String.format("Message \"%s\" is processed", messageContent);
	        return responseContent.getBytes();
	    }

	
}
