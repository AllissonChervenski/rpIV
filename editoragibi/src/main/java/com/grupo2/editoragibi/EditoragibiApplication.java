package com.grupo2.editoragibi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EditoragibiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EditoragibiApplication.class, args);
		//System.out.println(new BCryptPasswordEncoder().encode("senha_editor"));
	}

}
