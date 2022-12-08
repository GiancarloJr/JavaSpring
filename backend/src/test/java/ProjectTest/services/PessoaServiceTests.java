package ProjectTest.services;

import ProjectTest.EntitiesForTests;
import ProjectTest.JavaSpring.dto.PessoaDTO;
import ProjectTest.JavaSpring.entities.Contato;
import ProjectTest.JavaSpring.entities.Pessoa;
import ProjectTest.JavaSpring.repositories.PessoaRepository;
import ProjectTest.JavaSpring.services.PessoaService;
import ProjectTest.JavaSpring.services.exceptions.DataBaseException;
import ProjectTest.JavaSpring.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;


@ExtendWith(SpringExtension.class)
public class PessoaServiceTests {

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    private long existenteId;
    private long inexistenteId;
    private long dependentId;
    private Pessoa pessoa;
    private Contato contato;
    private PessoaDTO pessoaDTO;

    @BeforeEach
    void setUp() throws Exception {
        existenteId = 1L;
        inexistenteId = 1000L;
        dependentId = 4L;
        pessoa = EntitiesForTests.createPessoa();
        contato = EntitiesForTests.createContato();
        pessoaDTO = EntitiesForTests.createPessoaDTO();


        Mockito.when(pessoaRepository.save(any())).thenReturn(pessoa);
        Mockito.when(pessoaRepository.findById(existenteId)).thenReturn(Optional.of(pessoa));
        Mockito.doNothing().when(pessoaRepository).deleteById(existenteId);
    }

    @Test
    public void buscarPorIdRetornaObjectoDTO() {

        PessoaDTO pessoaDTO = pessoaService.buscarPessoaPorID(existenteId);

        Assertions.assertNotNull(pessoaDTO);

    }

    @Test
    public void deletePersonWhenPersonHasNoContact() {

        pessoa.getContatos().clear();
        Assertions.assertDoesNotThrow(() -> {
            pessoaService.deletarPessoa(existenteId);
        });
        Mockito.verify(pessoaRepository, Mockito.times(1)).deleteById(existenteId);
    }

    @Test
    public void deletePersonWhenPersonHasContact() {

        Assertions.assertThrows(DataBaseException.class, () -> {
            pessoaService.deletarPessoa(existenteId);
        });
    }

    @Test
    public void findByIdReturnDTOWhenIdExists() {

        PessoaDTO productDTO = pessoaService.buscarPessoaPorID(existenteId);

        Assertions.assertEquals(productDTO.getId(), existenteId);
    }


    @Test
    public void findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists() {

        Assertions.assertThrows(ObjectNotFoundException.class, () -> {
            pessoaService.buscarPessoaPorID(inexistenteId);
        });
    }
}
