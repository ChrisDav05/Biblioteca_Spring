package br.edu.ifpi.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpi.demo.entidades.Emprestimo;
import java.util.List;

public interface EmprestimoRepository extends JpaRepository <Emprestimo, Long> {
    List<Emprestimo> findById(long id);
}
