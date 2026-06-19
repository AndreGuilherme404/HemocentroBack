package hemocentro.services;

import hemocentro.dto.PessoaResponseDTO;
import hemocentro.dto.UsuarioRequestDTO;
import hemocentro.dto.UsuarioResponseDTO;
import hemocentro.entities.Pessoa;
import hemocentro.entities.Usuario;
import hemocentro.exceptions.DatabaseException;
import hemocentro.exceptions.ResourceNotFoundException;
import hemocentro.exceptions.UnauthorizedException;
import hemocentro.repositories.PessoaRepository;
import hemocentro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LoginService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Transactional
    public UsuarioResponseDTO login(UsuarioRequestDTO dto) throws UnauthorizedException {
        Usuario entity = usuarioRepository.findByLoginAndSenha(dto.getLogin(), dto.getSenha());
        if(entity != null){
            return new UsuarioResponseDTO(entity);
        }else{
            throw new UnauthorizedException("Erro ao logar (login ou senha incorretos).");
        }
    }
}
