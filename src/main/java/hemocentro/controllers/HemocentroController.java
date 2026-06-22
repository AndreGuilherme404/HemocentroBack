package hemocentro.controllers;

import hemocentro.dto.HemocentroRequestDTO;
import hemocentro.dto.HemocentroResponseDTO;
import hemocentro.dto.UsuarioResponseDTO;
import hemocentro.services.HemocentroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hemocentro")
public class HemocentroController {
    private final HemocentroService hemocentroService;

    public HemocentroController(HemocentroService hemocentroService) {
        this.hemocentroService = hemocentroService;
    }

    // listar
    @GetMapping
    public ResponseEntity<List<HemocentroResponseDTO>> listar() {
        List<HemocentroResponseDTO> list = hemocentroService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{hemocentroId}/usuarios")
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios(
            @PathVariable Long hemocentroId) {

        return ResponseEntity.ok(
                hemocentroService.listarPorHemocentro(hemocentroId));
    }

    // buscar por id
    @GetMapping("/{hemocentroId}")
    public ResponseEntity<HemocentroResponseDTO> buscar(@PathVariable Long hemocentroId) {
        HemocentroResponseDTO dto = hemocentroService.buscar(hemocentroId);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    // create
    @PostMapping
    public ResponseEntity<HemocentroResponseDTO> criar(@Valid @RequestBody HemocentroRequestDTO dto) {
        HemocentroResponseDTO novo = hemocentroService.inserir(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<HemocentroResponseDTO> alterar(@PathVariable Long id,
            @Valid @RequestBody HemocentroRequestDTO dto) {
        HemocentroResponseDTO novo = hemocentroService.alterar(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(novo);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        hemocentroService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
