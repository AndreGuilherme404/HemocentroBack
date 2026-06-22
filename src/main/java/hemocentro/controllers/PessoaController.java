package hemocentro.controllers;

import hemocentro.dto.PessoaRequestDTO;
import hemocentro.dto.PessoaResponseDTO;
import hemocentro.dto.UsuarioResponseDTO;
import hemocentro.services.PessoaService;
import hemocentro.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    private final PessoaService pessoaService;
    private final UsuarioService usuarioService;

    public PessoaController(PessoaService pessoaService, UsuarioService usuarioService) {
        this.pessoaService = pessoaService;
        this.usuarioService = usuarioService;
    }

    // listar
    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> listar() {
        List<PessoaResponseDTO> list = pessoaService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    // buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> buscar(@PathVariable Long id) {
        PessoaResponseDTO dto = pessoaService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    // listar usuarios
    @GetMapping("/{pessoaId}/usuarios")
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuariosPorPessoa(
            @PathVariable Long pessoaId) {

        List<UsuarioResponseDTO> list = usuarioService.listarPorPessoa(pessoaId);
        return ResponseEntity.ok().body(list);
    }

    // create
    @PostMapping
    public ResponseEntity<PessoaResponseDTO> criar(@Valid @RequestBody PessoaRequestDTO dto) {
        PessoaResponseDTO novo = pessoaService.inserir(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> alterar(@PathVariable Long id, @Valid @RequestBody PessoaRequestDTO dto) {
        PessoaResponseDTO novo = pessoaService.alterar(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(novo);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pessoaService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
