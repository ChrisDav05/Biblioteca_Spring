package br.edu.ifpi.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpi.demo.entidades.Usuario;
import java.util.List;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
    List<Usuario> findById(long id);
}
