package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.Service.CrudCargoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Boolean system = true;

	private final CrudCargoService cargoService;

	public SpringDataApplication(CrudCargoService cargoService) { // constructor injection
		this.cargoService = cargoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while(system) {
			System.out.print("Qual ação deseja realizar?\n"
					+ "0 - Sair\n"
					+ "1 - Cargo\n"
					+ "Opção: ");

			int action = scanner.nextInt();
			if(action == 1) {
				cargoService.iniciar(scanner);
			} else {
				system = false;
			}
		}
	}
}
