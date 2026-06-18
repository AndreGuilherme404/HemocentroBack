package hemocentro.controllers;



import hemocentro.dto.ExameRequestDTO;
import hemocentro.dto.ExameResponseDTO;
import hemocentro.entities.Exame;
import hemocentro.services.ExameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/exame")
public class ExameController {
    @Autowired
    private ExameService exameService;
    //listar
    @GetMapping
    public ResponseEntity<List<ExameResponseDTO>> listar(){
        List<ExameResponseDTO> list = exameService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<ExameResponseDTO> buscar(@PathVariable Long id){
        ExameResponseDTO dto = exameService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    //create
    @PostMapping
    public ResponseEntity<ExameResponseDTO> criar(@Valid @RequestBody ExameRequestDTO dto){
        ExameResponseDTO novo = exameService.inserir(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }
    //update
    @PutMapping("/{id}")
    public ResponseEntity<ExameResponseDTO> alterar(@PathVariable Long id,@Valid @RequestBody ExameRequestDTO dto){
        ExameResponseDTO novo = exameService.alterar(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(novo);
    }
    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        exameService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
