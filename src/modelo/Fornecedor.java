package modelo;

public class Fornecedor extends Contato{

    private String servico;

    public Fornecedor(String nome, String email, String servidor) {
        super(nome, email);
        this.servico = servidor;
    }

    public String getServico(){
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    @Override
    public String getTipo() {
        return TipoContato.FORNECEDOR.name();
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", servico='" + servico + '\'' +
                '}';
    }
}
