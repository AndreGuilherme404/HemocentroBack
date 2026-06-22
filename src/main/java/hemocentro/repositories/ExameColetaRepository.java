package hemocentro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hemocentro.entities.ExameColeta;

public interface ExameColetaRepository extends JpaRepository<ExameColeta, Long> {
    List<ExameColeta> findAllByColetaId(Long coletaId);
}
