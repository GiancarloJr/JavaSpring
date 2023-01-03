package ProjectTest.JavaSpring.resources;

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
    public ResponseEntity<ContatoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(contatoService.buscarPorId(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ContatoDTO>> buscarTodos() {
        return ResponseEntity.ok().body(contatoService.buscarTodos());
    }

    @PostMapping("/")
    public ResponseEntity<ContatoDTO> inserir(@Valid @RequestBody ContatoDTO ContatoDTO) {
        return ResponseEntity.ok().body(contatoService.salvarContato(ContatoDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ContatoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ContatoDTO ContatoDTO) {
        return ResponseEntity.ok().body(contatoService.atualizarContato(id, ContatoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        contatoService.deletarContato(id);
        return ResponseEntity.noContent().build();
    }
}
