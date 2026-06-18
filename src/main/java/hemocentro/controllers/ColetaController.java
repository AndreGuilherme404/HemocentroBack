package hemocentro.controllers;




import hemocentro.dto.ColetaRequestDTO;
import hemocentro.dto.ColetaResponseDTO;


import hemocentro.dto.ExameColetaResponseDTO;
import hemocentro.services.ColetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coleta")
public class ColetaController {
    @Autowired
    private ColetaService coletaService;
    //listar
    @GetMapping
    public ResponseEntity<List<ColetaResponseDTO>> listar(){
        List<ColetaResponseDTO> list = coletaService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<ColetaResponseDTO> buscar(@PathVariable Long id){
        ColetaResponseDTO dto = coletaService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    //create
    @PostMapping
    public ResponseEntity<ColetaResponseDTO> criar(@Valid @RequestBody ColetaRequestDTO dto){
        ColetaResponseDTO novo = coletaService.inserir(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }
    //update
    @PutMapping("/{id}")
    public ResponseEntity<ColetaResponseDTO> alterar(@PathVariable Long id,@Valid @RequestBody ColetaRequestDTO dto){
        ColetaResponseDTO novo = coletaService.alterar(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(novo);
    }
    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        coletaService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
