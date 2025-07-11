package com.BC.SzakGyak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SzakGyakApplication {

	public static void main(String[] args) {
		SpringApplication.run(SzakGyakApplication.class, args);

		// Küldj WhatsApp üzenetet indulás után
		WhatsAppSender.sendMessage("+36202126536", "Szia! Ez egy WhatsApp tesztüzenet Java-ból.");
	}
}
