package hemocentro.repositories;

import hemocentro.entities.Pessoa;
import hemocentro.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByLoginAndSenha(String login, String senha);
}
