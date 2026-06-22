package hemocentro.controllers;

import hemocentro.dto.UsuarioRequestDTO;
import hemocentro.dto.UsuarioResponseDTO;
import hemocentro.exceptions.UnauthorizedException;
import hemocentro.services.LoginService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth/login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> login(@Valid @RequestBody UsuarioRequestDTO dto)
            throws UnauthorizedException {
        UsuarioResponseDTO response = loginService.login(dto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
