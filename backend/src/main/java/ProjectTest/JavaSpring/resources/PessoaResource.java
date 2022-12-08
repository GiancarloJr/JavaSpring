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
    public ResponseEntity<PessoaDTO> buscarPessoaPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(pessoaService.buscarPessoaPorID(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PessoaDTO>> buscarTodasPessoasSemMostrarContatos() {
        return ResponseEntity.ok().body(pessoaService.buscarPessoasSemMostrarContatos());
    }

    @GetMapping("/allcompleto")
    public ResponseEntity<List<PessoaDTO>> buscarTodasPessoasMostrarContatos() {
        return ResponseEntity.ok().body(pessoaService.buscarPessoasMostrarContatos());
    }

    @PostMapping("/")
    public ResponseEntity<PessoaDTO> adicionarPessoa(@Valid @RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.ok().body(pessoaService.salvarPessoa(pessoaDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PessoaDTO> atualizarPessoa(@PathVariable Long id, @Valid @RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.ok().body(pessoaService.atualizarPessoa(id, pessoaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable("id") Long id) {
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }

}
