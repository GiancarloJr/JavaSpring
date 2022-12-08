package ProjectTest.entities;

import ProjectTest.JavaSpring.entities.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class PessoaTests {

    @Test
    public void pessoaEstruturaCorreta() {

        Pessoa entity = new Pessoa();
        entity.setId(1L);
        entity.setEmail("giancarlo@hotmail.com");
        entity.setName("Giancarlo Junior");
        entity.setContatos(Collections.emptyList());
        entity.setUF("GO");
        entity.setCEP(75909796L);
        entity.setBairro("Interlagos");
        entity.setLogradouro("Rua Geronimo");
        entity.setCPF("01582728119");
        entity.setComplemento("Em frente a praça");

        Assertions.assertNotNull(entity.getId());
        Assertions.assertNotNull(entity.getEmail());
        Assertions.assertNotNull(entity.getBairro());
        Assertions.assertEquals(entity.getContatos(), Collections.emptyList());
        Assertions.assertNotNull(entity.getUF());
        Assertions.assertNotNull(entity.getLogradouro());
        Assertions.assertNotNull(entity.getComplemento());
        Assertions.assertNotNull(entity.getCPF());
        Assertions.assertNotNull(entity.getCEP());

    }
}
