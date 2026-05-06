package modelo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AgendaArquivo implements Persistencia {

    private static final String ARQUIVO_CONTATOS = "contatos.txt";
    private static final String SEPARADOR = ";";

    @Override
    public void salvar(List<Contato> contatos) throws Exception {
        Path caminho = Paths.get(ARQUIVO_CONTATOS);
        List<String> linhas = new ArrayList<>();

        for (Contato contato : contatos) {
            String linha = formatarContato(contato);
            linhas.add(linha);
        }

        Files.write(caminho, linhas);
    }

    @Override
    public List<Contato> carregar() throws Exception {
        Path caminho = Paths.get(ARQUIVO_CONTATOS);
        List<Contato> contatos = new ArrayList<>();

        if (!Files.exists(caminho)) {
            return contatos;
        }

        List<String> linhas = Files.readAllLines(caminho);

        for (String linha : linhas) {
            if (linha.trim().isEmpty()) {
                continue;
            }

            Contato contato = desserializarContato(linha);
            if (contato != null) {
                contatos.add(contato);
            }
        }

        return contatos;
    }

    private String formatarContato(Contato contato) {
        if (contato instanceof Cliente) {
            Cliente cliente = (Cliente) contato;
            return TipoContato.CLIENTE.name() + SEPARADOR +
                    cliente.getNome() + SEPARADOR +
                    cliente.getEmail() + SEPARADOR +
                    cliente.getEmpresa();
        } else if (contato instanceof Fornecedor) {
            Fornecedor fornecedor = (Fornecedor) contato;
            return TipoContato.FORNECEDOR.name() + SEPARADOR +
                    fornecedor.getNome() + SEPARADOR +
                    fornecedor.getEmail() + SEPARADOR +
                    fornecedor.getServico();
        }
        return "";
    }

    private Contato desserializarContato(String linha) {
        String[] partes = linha.split(SEPARADOR);

        if (partes.length < 4) {
            return null;
        }

        String tipo = partes[0];
        String nome = partes[1];
        String email = partes[2];
        String extra = partes[3];

        if (tipo.equals(TipoContato.CLIENTE.name())) {
            return new Cliente(nome, email, extra);
        } else if (tipo.equals(TipoContato.FORNECEDOR.name())) {
            return new Fornecedor(nome, email, extra);
        }

        return null;
    }

}
