package ProjectTest.JavaSpring.resources;

import ProjectTest.JavaSpring.dto.PessoaDTO;
import ProjectTest.JavaSpring.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(pessoaService.findByID(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PessoaDTO>> findAll(){
        return ResponseEntity.ok().body(pessoaService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<PessoaDTO> insert(@Valid @RequestBody PessoaDTO pessoaDTO){
            return ResponseEntity.ok().body(pessoaService.insert(pessoaDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PessoaDTO> update(@PathVariable Long id,@Valid @RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.ok().body(pessoaService.update(id,pessoaDTO));
    }

}
