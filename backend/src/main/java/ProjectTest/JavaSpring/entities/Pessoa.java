package ProjectTest.JavaSpring.entities;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PESSOAS")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PES_ID")
    private Long id;

    @Column(name = "PES_NAME")
    private String name;

    @Column(name = "PES_CPF")
    private String CPF;

    @Column(name = "PES_EMAIL")
    private String email;

    @Column(name = "PES_CEP")
    private Long CEP;

    @Column(name = "PES_LOGRADOURO")
    private String Logradouro;

    @Column(name = "PES_COMPLEMENTO")
    private Long Complemento;

    @Column(name = "PES_BAIRRO")
    private String Bairro;

    @Column(name = "PES_UF")
    private String UF;

    @Column
    @OneToMany(mappedBy = "pessoa")
    private List<Contato> contatos;


}
