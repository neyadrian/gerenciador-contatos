import modelo.*;

import java.util.Scanner;

public class Main {

    private static Agenda agenda;
    private static Scanner scanner;

    public static void main(String[] args) {
        Persistencia persistencia = new AgendaArquivo();
        agenda = new Agenda(persistencia);

        agenda.carregarContatos();

        scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            System.out.print("Escolha uma opcao: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                processarOpcao(opcao);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido!\n");
                opcao =- 1;
            }
        } while (opcao != 0);

        scanner.close();
        System.out.println("Programa encerrado!");
    }

    private static void exibirMenu() {
        System.out.println("\n========== GERENCIADOR DE CONTATOS ==========");
        System.out.println("1 - Adicionar Cliente");
        System.out.println("2 - Adicionar Fornecedor");
        System.out.println("3 - Listar Contatos");
        System.out.println("4 - Buscar por Nome");
        System.out.println("5 - Atualizar Contato");
        System.out.println("6 - Remover Contato");
        System.out.println("0 - Sair");
        System.out.println("============================================");
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarCliente();
                break;
            case 2:
                adicionarFornecedor();
                break;
            case 3:
                agenda.listarContatos();
                break;
            case 4:
                buscarPorNome();
                break;
            case 5:
                atualizarContato();
                break;
            case 6:
                removerContato();
                break;
            case 0:
                agenda.salvarContatos();
                System.out.println("Encerrando...");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.\n");
        }
    }

    private static void adicionarCliente() {
        System.out.println("\n========== ADICIONAR CLIENTE ==========");

        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Email do cliente: ");
        String email = scanner.nextLine();

        System.out.print("Empresa: ");
        String empresa = scanner.nextLine();

        if (nome.isBlank() || email.isBlank() || empresa.isBlank()) {
            System.out.println("Erro: Todos os campos são obrigatórios!");
            return;
        }

        Cliente cliente = new Cliente(nome, email, empresa);
        if (agenda.adicionarContato(cliente)) {
            agenda.salvarContatos();
        }
    }

    private static void adicionarFornecedor() {
        System.out.println("\n========== ADICIONAR FORNECEDOR ==========");

        System.out.print("Nome do fornecedor: ");
        String nome = scanner.nextLine();

        System.out.print("Email do fornecedor: ");
        String email = scanner.nextLine();

        System.out.print("Serviço: ");
        String servico = scanner.nextLine();

        if (nome.isBlank() || email.isBlank() || servico.isBlank()) {
            System.out.println("Erro: Todos os campos são obrigatórios!");
            return;
        }

        Fornecedor fornecedor = new Fornecedor(nome, email, servico);
        if (agenda.adicionarContato(fornecedor)) {
            agenda.salvarContatos();
        }
    }

    private static void buscarPorNome() {
        System.out.print("\nDigite o nome do contato (ou parte dele): ");
        String nome = scanner.nextLine();

        if (nome.isBlank()) {
            System.out.println("Erro: Digite um nome para buscar!");
            return;
        }

        agenda.buscarPorNome(nome);
    }

    private static void atualizarContato() {
        System.out.print("\nDigite o nome do contato a atualizar: ");
        String nome = scanner.nextLine();

        if (nome.isBlank()) {
            System.out.println("Erro: Digite um nome!");
            return;
        }

        if (agenda.atualizarContato(nome)) {
            agenda.salvarContatos();
        }
    }

    private static void removerContato() {
        System.out.print("\nDigite o nome do contato a remover: ");
        String nome = scanner.nextLine();

        if (nome.isBlank()) {
            System.out.println("Erro: Digite um nome!");
            return;
        }

        if (agenda.removerContato(nome)) {
            agenda.salvarContatos();
        }
    }
}