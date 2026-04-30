package modelo;

import java.util.List;

public interface Persistencia {

    void salvar(List<Contato> contatos) throws Exception;
    List<Contato> carregar() throws Exception;
}
