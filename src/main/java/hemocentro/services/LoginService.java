package hemocentro.services;

import hemocentro.dto.UsuarioRequestDTO;
import hemocentro.dto.UsuarioResponseDTO;
import hemocentro.entities.Pessoa;
import hemocentro.exceptions.DatabaseException;
import hemocentro.exceptions.ResourceNotFoundException;
import hemocentro.exceptions.UnauthorizedException;
import hemocentro.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LoginService {
    @Autowired
    PessoaRepository pessoaRepository;
    @Transactional
    public UsuarioResponseDTO login(UsuarioRequestDTO dto) throws UnauthorizedException {
        Pessoa entity = pessoaRepository.findByCpf(dto.getCpf()).orElseThrow(() -> new ResourceNotFoundException("Não foi possível encontrar uma pessoa com cpf " + dto.getCpf()));
        if(entity.getSenha().equals(dto.getSenha())){
            return new UsuarioResponseDTO(entity);
        }else{
            throw new UnauthorizedException("Senha incorreta.");
        }
    }
}
