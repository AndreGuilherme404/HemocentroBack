package hemocentro.repositories;

import hemocentro.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByCpf(String cpf);
    boolean existsByCpf(String cpf);
}
