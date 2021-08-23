package com.helloworld.hello.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;	

@SpringBootApplication
@RestController
@RequestMapping ("/")

public class helloController {
	
	@GetMapping ("/page1")
	public String hello1() {
		return"Exercício 1: habilidades e mentalidades\r\n"
				+ "utilizadas para realizar essa atividade:<br>\r\n"
				+ "Mentalidade de crescimento\r\n"
					+ "	Orientação aos Detalhes";
		}
	
	@GetMapping ("/page2")
	public String hello2() {
		return"Exercício 2: objetivos de aprendizagem para\r\n"
				+ "essa semana:<br>\r\n"
				+"Conseguir entender Spring e como utilizar na prática.\r\n";
				
		}
	
}
