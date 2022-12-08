package ProjectTest.JavaSpring.services;

import ProjectTest.JavaSpring.dto.ContatoDTO;
import ProjectTest.JavaSpring.entities.Contato;
import ProjectTest.JavaSpring.entities.Pessoa;
import ProjectTest.JavaSpring.repositories.ContatoRepository;
import ProjectTest.JavaSpring.repositories.PessoaRepository;
import ProjectTest.JavaSpring.services.exceptions.DataBaseException;
import ProjectTest.JavaSpring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public ContatoDTO buscarPorId(Long id) {
        try {
            Optional<Contato> entity = contatoRepository.findById(id);
            return new ContatoDTO(entity.get());
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("CONTATO NAO ENCONTRADO");
        }
    }

    public List<ContatoDTO> buscarTodos() {
        List<Contato> list = contatoRepository.findAll();
        return list.stream().map(x -> new ContatoDTO(x)).collect(Collectors.toList());
    }

    public ContatoDTO salvarContato(ContatoDTO contatoDTO) {
        validacaoPessoa(contatoDTO);
        try {
            Contato entity = new Contato();
            convertDTOtoEntity(entity, contatoDTO);
            entity.getPessoa().getContatos().clear();
            return new ContatoDTO(contatoRepository.save(entity));
        } catch (NullPointerException e) {
            throw new ObjectNotFoundException("EMAIL DE USUARIO INEXISTENTE");
        }
    }

    public ContatoDTO atualizarContato(Long id, ContatoDTO contatoDTO) {
        validacaoPessoa(contatoDTO);
        try {
            Optional<Contato> entity = contatoRepository.findById(id);
            convertDTOtoEntity(entity.get(), contatoDTO);
            return new ContatoDTO(contatoRepository.save(entity.get()));
        } catch (NullPointerException e) {
            throw new ObjectNotFoundException("CONTATO NAO ENCONTRADO");
        }
    }

    public void convertDTOtoEntity(Contato entity, ContatoDTO contatoDTO) {
        entity.setNome(contatoDTO.getNome());
        entity.setCelular(contatoDTO.getCelular());
        entity.setTelefone(contatoDTO.getTelefone());
        entity.setPessoa(pessoaRepository.findByEmail(contatoDTO.getEmail()).get());
    }

    public void deletarContato(Long id) {
        try {
            contatoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ObjectNotFoundException("CONTATO NAO ENCONTRADO");
        }
    }

    public void validacaoPessoa(ContatoDTO contatoDTO){
        Pessoa pessoa = pessoaRepository.findByEmail(contatoDTO.getEmail().toLowerCase()).orElseThrow(()-> new DataBaseException("EMAIL NÃO CADASTRADO"));
    }

}
