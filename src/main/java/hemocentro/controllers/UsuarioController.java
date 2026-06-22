package hemocentro.controllers;

import hemocentro.dto.UsuarioRequestDTO;
import hemocentro.dto.UsuarioResponseDTO;
import hemocentro.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // listar
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
        List<UsuarioResponseDTO> list = usuarioService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    // buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscar(@PathVariable Long id) {
        UsuarioResponseDTO dto = usuarioService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    // create
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(@Valid @RequestBody UsuarioRequestDTO dto) {
        UsuarioResponseDTO novo = usuarioService.inserir(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> alterar(@PathVariable Long id,
            @Valid @RequestBody UsuarioRequestDTO dto) {
        UsuarioResponseDTO novo = usuarioService.alterar(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(novo);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
