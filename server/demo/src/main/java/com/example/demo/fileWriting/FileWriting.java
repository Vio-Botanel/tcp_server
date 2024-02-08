package com.example.demo.fileWriting;

import com.example.demo.service.impl.MessageServiceServerImpl;

import ch.qos.logback.classic.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Component
public class FileWriting {

	@Value("${tcp.server.messagesToFile.path}")
	private String path;

	public void saveMessageToFile(String message) {
		String pathStr = path;
		Path path = Paths.get(pathStr);
		try {
			Files.write(path, message.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
