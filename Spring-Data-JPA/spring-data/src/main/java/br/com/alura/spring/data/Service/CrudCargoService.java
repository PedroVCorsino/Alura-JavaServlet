package br.com.alura.spring.data.Service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {

    private final CargoRepository repository;

    public CrudCargoService(CargoRepository repository) {
        this.repository = repository;
    }


    public void iniciar(Scanner scanner) {
        salvar(scanner);
    }

    public void salvar(Scanner scanner) {
        String descricao = new String();
        Cargo cargo = new Cargo();

        System.out.println("Descrição do cargo: ");
        descricao = scanner.next();
        cargo.setDescricao(descricao);
        
        repository.save(cargo);
        System.out.println("Salvo");
    }



}
