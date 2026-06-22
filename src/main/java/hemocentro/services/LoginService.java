package hemocentro.services;

import hemocentro.dto.UsuarioRequestDTO;
import hemocentro.dto.UsuarioResponseDTO;
import hemocentro.entities.Usuario;
import hemocentro.exceptions.UnauthorizedException;
import hemocentro.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {
    private final UsuarioRepository usuarioRepository;

    public LoginService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public UsuarioResponseDTO login(UsuarioRequestDTO dto) throws UnauthorizedException {
        Usuario entity = usuarioRepository.findByLoginAndSenha(dto.getLogin(), dto.getSenha());
        if (entity != null) {
            return new UsuarioResponseDTO(entity);
        } else {
            throw new UnauthorizedException("Erro ao logar (login ou senha incorretos).");
        }
    }
}
