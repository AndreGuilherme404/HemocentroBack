package hemocentro.controllers;

import hemocentro.dto.LoginRequestDTO;
import hemocentro.dto.UsuarioResponseDTO;
import hemocentro.exceptions.UnauthorizedException;
import hemocentro.services.LoginService;
import jakarta.validation.Valid;
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
    public ResponseEntity<UsuarioResponseDTO> login(
            @Valid @RequestBody LoginRequestDTO dto)
            throws UnauthorizedException {

        UsuarioResponseDTO response = loginService.login(dto);

        return ResponseEntity.ok(response);
    }
}
