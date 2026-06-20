package hemocentro.controllers;

import hemocentro.dto.LoginRequestDTO;
import hemocentro.dto.UsuarioRequestDTO;
import hemocentro.dto.UsuarioResponseDTO;
import hemocentro.exceptions.UnauthorizedException;
import hemocentro.services.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> login(@Valid @RequestBody LoginRequestDTO dto) throws UnauthorizedException {
        System.out.println("Tentativa de login recebida para o login: " + dto.getLogin());
        UsuarioResponseDTO response = loginService.login(dto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
