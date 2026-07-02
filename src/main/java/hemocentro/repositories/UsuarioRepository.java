package hemocentro.repositories;

import hemocentro.entities.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByLoginAndSenha(String login, String senha);

    Usuario findByLogin(String login);

    boolean existsByLogin(String login);

    List<Usuario> findByHemocentroId(Long hemocentroId);

    List<Usuario> findAllByPessoaId(Long pessoaId);

}
