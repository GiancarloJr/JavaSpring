package ProjectTest.JavaSpring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CONTATOS")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CON_ID")
    private Long id;

    @Column(name = "CON_NAME")
    private String nome;

    @Column(name = "CON_TELEFONE")
    private Long telefone;

    @Column(name = "CON_CELULAR")
    private Long celular;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "PESSOA_ID", referencedColumnName = "PES_ID")
    private Pessoa pessoa;

    public Contato() {

    }

    public Contato(Long id, String nome, Long telefone, Long celular, Pessoa pessoa) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.celular = celular;
        this.pessoa = pessoa;
    }

    public Contato(Long id, String nome, Long telefone, Long celular) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.celular = celular;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return id.equals(contato.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
