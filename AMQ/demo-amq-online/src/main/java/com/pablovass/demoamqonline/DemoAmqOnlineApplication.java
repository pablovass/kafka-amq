package com.pablovass.demoamqonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
@EnableJms
@SpringBootApplication
public class DemoAmqOnlineApplication implements  CommandLineRunner {

	@Autowired
	private JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoAmqOnlineApplication.class, args);
	}
	@Override
	public void run(String... strings) throws Exception {
		sendMessage("Hello World!");
	}

	public void sendMessage(String text) {
		System.out.println(String.format("Sending '%s'", text));
		this.jmsTemplate.convertAndSend("example", text);
	}

	@JmsListener(destination = "example")
	public void receiveMessage(String text) {
		System.out.println(String.format("Received '%s'", text));
	}
}
