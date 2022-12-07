package ProjectTest.JavaSpring.services;

import ProjectTest.JavaSpring.dto.PessoaDTO;
import ProjectTest.JavaSpring.entities.Pessoa;
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
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDTO findByID(Long id){
        try {
            Optional<Pessoa> entity = pessoaRepository.findById(id);
            return new PessoaDTO(entity.get());
        } catch (NoSuchElementException e){
            throw new ObjectNotFoundException("USUARIO NÃO ENCONTRADO");
        }
    }

    public List<PessoaDTO> findAll() {
        List<Pessoa> list = pessoaRepository.findAll();
        for(Pessoa pessoa: list){
            pessoa.getContatos().clear();
        }
        return list.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
    }

    public PessoaDTO insert(PessoaDTO pessoaDTO) {
            Pessoa entity = new Pessoa();
            convertDTOtoEntity(entity, pessoaDTO);
            return new PessoaDTO(pessoaRepository.save(entity));
    }

    public PessoaDTO update(Long id,PessoaDTO pessoaDTO) {
        try {
            Optional<Pessoa> entity = pessoaRepository.findById(id);
            convertDTOtoEntity(entity.get(), pessoaDTO);
            return new PessoaDTO(pessoaRepository.save(entity.get()));
        } catch (NoSuchElementException e){
            throw new ObjectNotFoundException("USUARIO NÃO ENCONTRADO");
        }
    }

    public void convertDTOtoEntity(Pessoa entity,PessoaDTO pessoaDTO){
        entity.setName(pessoaDTO.getName());
        entity.setBairro(pessoaDTO.getBairro());
        entity.setCEP(pessoaDTO.getCEP());
        entity.setComplemento(pessoaDTO.getComplemento());
        entity.setCPF(pessoaDTO.getCPF());
        entity.setLogradouro(pessoaDTO.getLogradouro());
        entity.setEmail(pessoaDTO.getEmail());
        entity.setUF(pessoaDTO.getUF());
    }

    public void deletarPessoa(Long id){
        try {
            pessoaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ObjectNotFoundException("USUARIO NÃO ENCONTRADO");
        }
    }
}
