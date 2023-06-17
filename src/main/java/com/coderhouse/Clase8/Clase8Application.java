package com.coderhouse.Clase8;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Clase8Application implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(Clase8Application.class, args);
	}


	//Metodo Run  para correr mis sentencias Java
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Acceda al Server desde aqui..http://localhost:8888/h2-console/login.jsp?");


	}
}