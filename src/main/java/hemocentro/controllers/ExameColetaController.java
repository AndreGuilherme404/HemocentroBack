package hemocentro.controllers;




import hemocentro.dto.ExameColetaRequestDTO;
import hemocentro.dto.ExameColetaResponseDTO;
import hemocentro.services.ExameColetaService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/exameColeta")
public class ExameColetaController {
    @Autowired
    private ExameColetaService exameColetaService;
    //listar
    @GetMapping
    public ResponseEntity<List<ExameColetaResponseDTO>> listar(){
        List<ExameColetaResponseDTO> list = exameColetaService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<ExameColetaResponseDTO> buscar(@PathVariable Long id){
        ExameColetaResponseDTO dto = exameColetaService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    //create
    @PostMapping
    public ResponseEntity<ExameColetaResponseDTO> criar(@Valid @RequestBody ExameColetaRequestDTO dto){
        ExameColetaResponseDTO novo = exameColetaService.inserir(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }
    //update
    @PutMapping("/{id}")
    public ResponseEntity<ExameColetaResponseDTO> alterar(@PathVariable Long id,@Valid @RequestBody ExameColetaRequestDTO dto){
        ExameColetaResponseDTO novo = exameColetaService.alterar(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(novo);
    }
    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        exameColetaService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
