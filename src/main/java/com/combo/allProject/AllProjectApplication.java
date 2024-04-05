package com.combo.allProject;

import com.combo.allProject.model.Anamnese;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class AllProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllProjectApplication.class, args);

		// Inicialização da instância de Anamnese dentro do método main()
		Anamnese anamnese = new Anamnese(null, new Date("2024-04-02T00:00:00"),
				70.5f, 1.85f, 80.0f, 100.0f, 22.0f, 56.4f, 14.1f, 30.0f, 23.0f);
	}
}