package ProjectTest.JavaSpring.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PESSOAS")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PES_ID")
    private Long id;

    @Column(name = "PES_NAME")
    private String name;

    @Column(name = "PES_CPF", unique = true)
    private String CPF;

    @Column(name = "PES_EMAIL", unique = true)
    private String email;

    @Column(name = "PES_CEP")
    private Long CEP;

    @Column(name = "PES_LOGRADOURO")
    private String logradouro;

    @Column(name = "PES_COMPLEMENTO")
    private String complemento;

    @Column(name = "PES_BAIRRO")
    private String bairro;

    @Column(name = "PES_UF")
    private String UF;

    @OneToMany(mappedBy = "pessoa")
    private List<Contato> contatos;

    public Pessoa() {

    }

    public Pessoa(Long id, String name, String CPF, String email, Long CEP, String logradouro, String complemento, String bairro, String UF) {
        this.id = id;
        this.name = name;
        this.CPF = CPF;
        this.email = email;
        this.CEP = CEP;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.UF = UF;
    }

    public Pessoa(Long id, String name, String name1, String cpf, String email, Long cep, String logradouro, String complemento, String bairro, String uf) {
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

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return id.equals(pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
