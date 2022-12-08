package ProjectTest.JavaSpring.repositories;

import ProjectTest.JavaSpring.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findByCPF(String cpf);

    Optional<Pessoa> findByEmail(String email);
}
