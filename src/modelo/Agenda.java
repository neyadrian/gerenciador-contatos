package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    private List<Contato> contatos;
    private Persistencia persistencia;

    public Agenda(Persistencia persistencia) {
        this.persistencia = persistencia;
        this.contatos = new ArrayList<>();
    }

    public boolean adicionarContato(Contato contato) {
        for (Contato c : contatos) {
            if (c.getEmail().equalsIgnoreCase(contato.getEmail())) {
                System.out.println("Erro: Email já cadastrado!");
                return false;
            }
        }

        contatos.add(contato);
        System.out.println("Contato adicionado com sucesso!");
        return true;
    }

    public void listarContatos() {
        if(contatos.isEmpty()) {
            System.out.println("\nNenhum contanto cadastrado.");
            return;
        }

        System.out.println("\n========== LISTA DE CONTATOS ==========");
        for(int i = 0; i < contatos.size(); i++) {
            Contato contato = contatos.get(i);
            System.out.println((i + 1) + ". " + contato);
        }
        System.out.println("======================================\n");
    }

    public void buscarPorNome(String nome) {
        List<Contato> resultados = new ArrayList<>();

        for (Contato contato : contatos) {
            if(contato.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultados.add(contato);
            }
        }

        if(resultados.isEmpty()) {
            System.out.println("\nNenhum contato encontrado com o nome: " + nome);
            return;
        }

        System.out.println("\n========== RESULTADOS DA BUSCA ==========");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println((i + 1) + ". " + resultados.get(i));
        }
        System.out.println("========================================\n");
    }

    public boolean atualizarContato(String nome) {
        Contato contatoEncontrado = null;

        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contatoEncontrado = contato;
                break;
            }
        }

        if (contatoEncontrado == null) {
            System.out.println("Contato não encontrado!");
            return false;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Novo nome (deixe em branco para manter): ");
        String novoNome = scanner.nextLine();
        if (!novoNome.isBlank()) {
            contatoEncontrado.setNome(novoNome);
        }

        System.out.print("Novo email (deixe em branco para manter): ");
        String novoEmail = scanner.nextLine();
        if (!novoEmail.isBlank()) {
            // Verifica se novo email já existe
            boolean emailExiste = false;
            for (Contato c : contatos) {
                if (!c.equals(contatoEncontrado) && c.getEmail().equalsIgnoreCase(novoEmail)) {
                    emailExiste = true;
                    break;
                }
            }

            if (emailExiste) {
                System.out.println("Erro: Este email já está cadastrado!");
            } else {
                contatoEncontrado.setEmail(novoEmail);
            }
        }

        if (contatoEncontrado instanceof Cliente) {
            Cliente cliente = (Cliente) contatoEncontrado;
            System.out.print("Nova empresa (deixe em branco para manter): ");
            String novaEmpresa = scanner.nextLine();
            if (!novaEmpresa.isBlank()) {
                cliente.setEmpresa(novaEmpresa);
            }
        } else if (contatoEncontrado instanceof Fornecedor) {
            Fornecedor fornecedor = (Fornecedor) contatoEncontrado;
            System.out.print("Novo serviço (deixe em branco para manter): ");
            String novoServico = scanner.nextLine();
            if (!novoServico.isBlank()) {
                fornecedor.setServico(novoServico);
            }
        }

        System.out.println("Contato atualizado com sucesso!");
        return true;
    }

    public boolean removerContato(String nome) {
        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).getNome().equalsIgnoreCase(nome)) {
                contatos.remove(i);
                System.out.println("Contato removido com sucesso!");
                return true;
            }
        }

        System.out.println("Contato não encontrado!");
        return false;
    }

    public void salvarContatos() {
        try {
            persistencia.salvar(contatos);
            System.out.println("Contatos salvos com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar contatos: " + e.getMessage());
        }
    }

    public void carregarContatos() {
        try {
            contatos = persistencia.carregar();
            System.out.println("Contatos carregados com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao carregar contatos: " + e.getMessage());
        }
    }

    public List<Contato> getContatos() {
        return new ArrayList<>(contatos);
    }
}
