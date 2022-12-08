package ProjectTest.JavaSpring.dto;

import ProjectTest.JavaSpring.entities.Contato;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ContatoDTO {

    private Long id;
    @Size(min = 3, max = 60, message = "Campo Nome Obrigatório")
    @NotEmpty
    @NotBlank
    private String nome;
    @NumberFormat
    private Long telefone;
    @NumberFormat
    private Long celular;
    @Email(message = "Email de usuario para adicionar contato obrigatório")
    private String emailPessoa;

    public ContatoDTO() {

    }

    public ContatoDTO(Long id, String nome, Long telefone, Long celular, String emailPessoa) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.celular = celular;
        this.emailPessoa = emailPessoa;
    }

    public ContatoDTO(Contato entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.telefone = entity.getTelefone();
        this.celular = entity.getCelular();
        this.emailPessoa = entity.getPessoa().getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return emailPessoa;
    }

    public void setEmail(String emailPessoa) {
        this.emailPessoa = emailPessoa;
    }
}
