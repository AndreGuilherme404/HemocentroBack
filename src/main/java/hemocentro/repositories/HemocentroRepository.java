package hemocentro.repositories;

import hemocentro.entities.Hemocentro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HemocentroRepository extends JpaRepository<Hemocentro, Long> {
    boolean existsByNome(String nome);
}
