package hemocentro.repositories;

import hemocentro.entities.Exame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExameRepository extends JpaRepository<Exame, Long> {
    boolean existsByNome(String nome);
}
