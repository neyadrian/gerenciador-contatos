package modelo;

public class Cliente extends Contato {

    private String empresa;

    public Cliente(String nome, String email, String empresa) {
        super(nome, email);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String getTipo() {
        return TipoContato.CLIENTE.name();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", empresa='" + empresa + '\'' +
                '}';
    }
}
