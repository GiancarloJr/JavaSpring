package ProjectTest.JavaSpring.entities;

import javax.persistence.*;

@Entity
@Table(name = "CONTATOS")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CON_ID")
    private Long id;

    @Column(name = "CON_NOME")
    private String nome;

    @Column(name = "CON_TELEFONE")
    private Long telefone;

    @Column(name = "CON_CELULAR")
    private Long celular;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "pes_id")
    private Pessoa pessoa;


}
