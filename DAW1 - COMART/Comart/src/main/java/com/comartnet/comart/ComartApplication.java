package com.comartnet.comart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComartApplication.class, args);
		System.out.println("TERMINE DE CARGAR");
	}

}
