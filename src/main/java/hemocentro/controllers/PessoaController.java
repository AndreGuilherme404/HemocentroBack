package hemocentro.controllers;


import hemocentro.dto.PessoaRequestDTO;
import hemocentro.dto.PessoaResponseDTO;
import hemocentro.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;
    //listar
    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> listar(){
        List<PessoaResponseDTO> list = pessoaService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> buscar(@PathVariable Long id){
        PessoaResponseDTO dto = pessoaService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    //create
    @PostMapping
    public ResponseEntity<PessoaResponseDTO> criar(@Valid @RequestBody PessoaRequestDTO dto){
        PessoaResponseDTO novo = pessoaService.inserir(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }
    //update
    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> alterar(@PathVariable Long id,@Valid @RequestBody PessoaRequestDTO dto){
        PessoaResponseDTO novo = pessoaService.alterar(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(novo);
    }
    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        pessoaService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
