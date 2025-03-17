package br.edu.ifpi.demo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpi.demo.Dto.EmprestimoDto;
import br.edu.ifpi.demo.entidades.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findById(EmprestimoDto livro_id);
}
