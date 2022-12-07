package ProjectTest.JavaSpring.resources;

import ProjectTest.JavaSpring.dto.ContatoDTO;
import ProjectTest.JavaSpring.dto.ContatoDTO;
import ProjectTest.JavaSpring.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoResource {

    @Autowired
    private ContatoService contatoService;

    @GetMapping("/{id}")
    public ResponseEntity<ContatoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(contatoService.findByID(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ContatoDTO>> findAll(){
        return ResponseEntity.ok().body(contatoService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<ContatoDTO> insert(@Valid @RequestBody ContatoDTO ContatoDTO){
        return ResponseEntity.ok().body(contatoService.insert(ContatoDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ContatoDTO> update(@PathVariable Long id,@Valid @RequestBody ContatoDTO ContatoDTO) {
        return ResponseEntity.ok().body(contatoService.update(id,ContatoDTO));
    }
}
