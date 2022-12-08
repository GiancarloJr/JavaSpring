package ProjectTest.JavaSpring.dto;

import ProjectTest.JavaSpring.entities.Contato;
import ProjectTest.JavaSpring.entities.Pessoa;

import javax.validation.constraints.*;
import java.util.List;

public class PessoaDTO {


    private Long id;
    @NotBlank(message = "Não pode estar em branco")
    @NotEmpty(message = "Não pode estar vazio")
    private String name;
    @NotBlank(message = "Não pode estar em branco")
    @NotEmpty(message = "Não pode estar vazio")
    @Size(min = 11, max = 11, message = "CPF Obrigado 11 Digitos")
    private String CPF;
    @NotBlank(message = "Não pode estar em branco")
    @NotEmpty(message = "Não pode estar vazio")
    @Email
    private String email;
    private Long CEP;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String UF;
    private List<Contato> contatos;

    public PessoaDTO() {
    }

    public PessoaDTO(Long id, String name, String CPF, String email, Long CEP, String logradouro, String complemento, String bairro, String UF, List<Contato> contatos) {
        this.id = id;
        this.name = name;
        this.CPF = CPF;
        this.email = email;
        this.CEP = CEP;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.UF = UF;
        this.contatos = contatos;
    }

    public PessoaDTO(Pessoa entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.CPF = entity.getCPF();
        this.email = entity.getEmail();
        this.CEP = entity.getCEP();
        this.logradouro = entity.getLogradouro();
        this.complemento = entity.getComplemento();
        this.bairro = entity.getBairro();
        this.UF = entity.getUF();
        this.contatos = entity.getContatos();
    }

    public PessoaDTO(Pessoa entity, List<Contato> contatos) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.CPF = entity.getCPF();
        this.email = entity.getEmail();
        this.CEP = entity.getCEP();
        this.logradouro = entity.getLogradouro();
        this.complemento = entity.getComplemento();
        this.bairro = entity.getBairro();
        this.UF = entity.getUF();
        this.contatos = contatos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCEP() {
        return CEP;
    }

    public void setCEP(Long CEP) {
        this.CEP = CEP;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public List<Contato> getContatos() {
        return contatos;
    }
}
