package modelo;

public enum TipoContato {
    CLIENTE("Cliente"),
    FORNECEDOR("Fornecedor");

    private final String descricao;

    TipoContato(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
