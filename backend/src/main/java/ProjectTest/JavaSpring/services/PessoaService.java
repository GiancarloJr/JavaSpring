package ProjectTest.JavaSpring.services;

import ProjectTest.JavaSpring.dto.PessoaDTO;
import ProjectTest.JavaSpring.entities.Pessoa;
import ProjectTest.JavaSpring.repositories.PessoaRepository;
import ProjectTest.JavaSpring.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        } catch (NotFoundException e){
            throw new NotFoundException("Pessoa não encontrada");
        }

    }

    public List<PessoaDTO> findAll() {
        List<Pessoa> list = pessoaRepository.findAll();
        return list.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
    }
}
