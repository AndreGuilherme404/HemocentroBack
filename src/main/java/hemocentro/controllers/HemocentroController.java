package hemocentro.controllers;

import hemocentro.dto.HemocentroRequestDTO;
import hemocentro.dto.HemocentroResponseDTO;
import hemocentro.services.HemocentroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hemocentro")
public class HemocentroController {
    @Autowired
    private HemocentroService hemocentroService;
    //listar
    @GetMapping
    public ResponseEntity<List<HemocentroResponseDTO>> listar(){
        List<HemocentroResponseDTO> list = hemocentroService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<HemocentroResponseDTO> buscar(@PathVariable Long id){
        HemocentroResponseDTO dto = hemocentroService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    //create
    @PostMapping
    public ResponseEntity<HemocentroResponseDTO> criar(@Valid @RequestBody HemocentroRequestDTO dto){
        HemocentroResponseDTO novo = hemocentroService.inserir(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }
    //update
    @PutMapping("/{id}")
    public ResponseEntity<HemocentroResponseDTO> alterar(@PathVariable Long id,@Valid @RequestBody HemocentroRequestDTO dto){
        HemocentroResponseDTO novo = hemocentroService.alterar(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(novo);
    }
    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        hemocentroService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
