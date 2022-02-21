package br.com.alura.spring.data.Service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {

    private Boolean system = true;
    private final CargoRepository repository;

    public CrudCargoService(CargoRepository repository) {
        this.repository = repository;
    }


    public void iniciar(Scanner scanner) {

        while(system) {
            System.out.println("Qual ação deseja realizar?\n"
                    + "0 - Sair\n"
                    + "1 - Salvar\n"
                    + "2 - Atualizar\n"
                    + "3 - Visualizar\n"
                    + "4 - Deletar\n"
                    + "Opção: ");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3:
                    visualizar();
                    break;
                case 4:
                    deletar(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
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

    public void atualizar(Scanner scanner) {
        int id = 0;
        String descricao = new String();
        Cargo cargo = new Cargo();

        System.out.println("Digite o ID do Cargo que deseja alterar: ");
        id = scanner.nextInt();
        System.out.println("Digite a nova descrição do Cargo: ");
        descricao = scanner.next();

        cargo.setId(id);
        cargo.setDescricao(descricao);
        repository.save(cargo);
        System.out.println("Atualizado");
    }

    private void visualizar(){
        repository.findAll().forEach(System.out::println);
    }

    private void deletar(Scanner scanner){ 
        int id = 0;
        System.out.println("Digite o ID do Cargo que deseja deletar: ");
        id = scanner.nextInt();
        repository.deleteById(id);
        System.out.println("Deletado");
    }


}
