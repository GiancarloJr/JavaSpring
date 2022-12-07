package ProjectTest.JavaSpring.services;

import ProjectTest.JavaSpring.dto.ContatoDTO;
import ProjectTest.JavaSpring.entities.Contato;
import ProjectTest.JavaSpring.repositories.ContatoRepository;
import ProjectTest.JavaSpring.repositories.PessoaRepository;
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

    public ContatoDTO findByID(Long id){
        try {
            Optional<Contato> entity = contatoRepository.findById(id);
            return new ContatoDTO(entity.get());
        } catch (NoSuchElementException e){
            throw new ObjectNotFoundException("CONTATO NAO ENCONTRADO");
        }
    }

    public List<ContatoDTO> findAll() {
        List<Contato> list = contatoRepository.findAll();
        return list.stream().map(x -> new ContatoDTO(x)).collect(Collectors.toList());
    }

    public ContatoDTO insert(ContatoDTO ContatoDTO) {
        try {
            Contato entity = new Contato();
            convertDTOtoEntity(entity, ContatoDTO);
            entity.getPessoa().getContatos().clear();
            return new ContatoDTO(contatoRepository.save(entity));
        } catch (NullPointerException e) {
            throw new ObjectNotFoundException("EMAIL DE USUARIO INEXISTENTE");
        }
    }

    public ContatoDTO update(Long id,ContatoDTO ContatoDTO) {
        try {
            Optional<Contato> entity = contatoRepository.findById(id);
            convertDTOtoEntity(entity.get(), ContatoDTO);
            return new ContatoDTO(contatoRepository.save(entity.get()));
        } catch (NullPointerException e){
            throw new ObjectNotFoundException("CONTATO NAO ENCONTRADO");
        }
    }

    public void convertDTOtoEntity(Contato entity,ContatoDTO contatoDTO){
        entity.setNome(contatoDTO.getNome());
        entity.setCelular(contatoDTO.getCelular());
        entity.setTelefone(contatoDTO.getTelefone());
        entity.setPessoa(pessoaRepository.findByEmail(contatoDTO.getEmail()));
    }

    public void deletarContato(Long id){
        try {
            contatoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ObjectNotFoundException("CONTATO NAO ENCONTRADO");
        }
    }

}
