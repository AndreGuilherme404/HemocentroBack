package hemocentro.controllers;

import hemocentro.dto.HemocentroResponseDTO;
import hemocentro.services.HemocentroService;
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


    //insert


    //update


    //delete


}
