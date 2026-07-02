package hemocentro.controllers;

import hemocentro.dto.ExameColetaRequestDTO;
import hemocentro.dto.ExameColetaResponseDTO;
import hemocentro.services.ExameColetaService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/exameColeta")
public class ExameColetaController {
    private final ExameColetaService exameColetaService;

    public ExameColetaController(ExameColetaService exameColetaService) {
        this.exameColetaService = exameColetaService;
    }

    // listar
    @GetMapping
    public ResponseEntity<List<ExameColetaResponseDTO>> listar(
            @RequestParam(name = "coletaId") Long coletaId) {

        List<ExameColetaResponseDTO> list = exameColetaService.listar(coletaId);

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExameColetaResponseDTO> buscar(
            @PathVariable Long id) {

        ExameColetaResponseDTO dto = exameColetaService.buscar(id);

        return ResponseEntity.ok(dto);
    }

    // create
    @PostMapping
    public ResponseEntity<ExameColetaResponseDTO> criar(@Valid @RequestBody ExameColetaRequestDTO dto) {
        ExameColetaResponseDTO novo = exameColetaService.inserir(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<ExameColetaResponseDTO> alterar(@PathVariable Long id,
            @Valid @RequestBody ExameColetaRequestDTO dto) {
        ExameColetaResponseDTO novo = exameColetaService.alterar(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(novo);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        exameColetaService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
