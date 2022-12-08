package ProjectTest.entities;

import ProjectTest.JavaSpring.entities.Contato;
import ProjectTest.JavaSpring.entities.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContatoTests {

    @Test
    public void contatoEstruturaCorreta() {

        Contato entity = new Contato();
        entity.setId(1L);
        entity.setNome("Giancarlo");
        entity.setTelefone(123454687L);
        entity.setCelular(999999999L);
        entity.setPessoa(new Pessoa());

        Assertions.assertNotNull(entity.getId());
        Assertions.assertNotNull(entity.getNome());
        Assertions.assertEquals(entity.getPessoa().getClass(), Pessoa.class);
        Assertions.assertNotNull(entity.getCelular());
        Assertions.assertNotNull(entity.getTelefone());
    }
}
