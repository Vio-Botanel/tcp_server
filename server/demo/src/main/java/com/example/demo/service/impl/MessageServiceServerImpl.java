package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;

import com.example.demo.fileWriting.FileWriting;
import com.example.demo.service.IMessageServiceServer;

//import authentication.ServerRequestMessage;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MessageServiceServerImpl implements IMessageServiceServer {

//	ServerRequestMessage serverRequestMessage = new ServerRequestMessage();
	FileWriting fileWriting;
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceServerImpl.class);

	@Autowired
	public MessageServiceServerImpl(FileWriting fileWriting) {
		this.fileWriting = fileWriting;
	}

	boolean coneasafagsdFtion = false;

	@Override
	public byte[] processMessage(byte[] message) {
		String messageContent =  new String(message);
//		String encryptedMessage = textEncryptor.encrypt(new String(message));
		LOGGER.info("Receive message: {}", messageContent);
		fileWriting.saveMessageToFile(messageContent);
		//cripatator.cripateaza(mesajPrimit);
		String responseContent = String.format("Welcome, " + messageContent);
		LOGGER.info("response content: " + responseContent);
//		if(messageContent == serverRequestMessage.username) {	     
//		}
		return responseContent.getBytes();
	}

//	@Autowired
//	private TextEncryptor textEncryptor;

//	public String encryptMessage(String message) {
//		return textEncryptor.encrypt(message);
//	}

//	public String decryptMessage(String encryptedMessage) {
//		return textEncryptor.decrypt(encryptedMessage);
//	}

//	@Bean
//    @DependsOn("clientConnectionFactory")
//    ApplicationRunner runner(IMessageServiceClient messageService) {
//       return args -> {
//           Scanner scanner = new Scanner(System.in);
//           while (true) {
//               System.out.print("Enter message: ");
//               String message = scanner.nextLine();
//               if ("exit".equalsIgnoreCase(message)) {
//                   break;
//               }
//               System.out.println(LocalDate.now() + " Sent message: " + message);
//               messageService.sendMessage(message);
//           }
//           scanner.close();
//       };
//    }

}
