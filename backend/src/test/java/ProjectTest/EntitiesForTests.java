package ProjectTest;


import ProjectTest.JavaSpring.dto.ContatoDTO;
import ProjectTest.JavaSpring.dto.PessoaDTO;
import ProjectTest.JavaSpring.entities.Contato;
import ProjectTest.JavaSpring.entities.Pessoa;

import java.util.ArrayList;


public class EntitiesForTests {

    public static Pessoa createPessoa() {
        Pessoa pessoa = new Pessoa(1L, "Giancarlo", "01582728119", "giancarlo@hotmail.com", 1234567L, "Rua Geronimo", "Praça", "Bairro", "GO");
        if (pessoa.getContatos() == null)
            pessoa.setContatos(new ArrayList<>());
        pessoa.getContatos().add(new Contato(1L, "Eletrônicos", 12345678L, 99999999L));
        return pessoa;
    }

    public static PessoaDTO createPessoaDTO() {
        return new PessoaDTO(createPessoa(), createPessoa().getContatos());
    }

    public static Contato createContato() {
        Contato category = new Contato(1L, "Eletrônicos", 12345678L, 99999999L);
        return category;
    }

    public static ContatoDTO createContatoDTO() {
        return new ContatoDTO(createContato());
    }
}
