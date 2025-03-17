package br.edu.ifpi.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpi.demo.entidades.Livro;
import br.edu.ifpi.demo.entidades.Usuario;
import br.edu.ifpi.demo.DemoApplication;
import br.edu.ifpi.demo.Dto.CreateEmpReqDto;
import br.edu.ifpi.demo.Dto.EmprestimoDto;
import br.edu.ifpi.demo.entidades.Emprestimo;
import br.edu.ifpi.demo.repositories.EmprestimoRepository;
import br.edu.ifpi.demo.repositories.LivroRepository;
import br.edu.ifpi.demo.repositories.UsuarioRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/emprestimos")
@RestController
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private LivroRepository livrorepository;
    @Autowired
    private UsuarioRepository usuariorepository;

    //ADICIONA UM EMPRÉSTIMO NO BANCO DE DADOS 
    @PostMapping()
    public ResponseEntity<Emprestimo> adicionarEmprestimo(@RequestBody CreateEmpReqDto dados) {
        Livro livro = livrorepository.findById(dados.livro_id()).orElse(null);
        livro.setEmprestado(true);
        Usuario usuario = usuariorepository.findById(dados.usuario_id()).orElse(null);

        Emprestimo emprestimoCriado = new Emprestimo(livro, usuario);
        emprestimoRepository.save(emprestimoCriado);
        return ResponseEntity.ok(emprestimoCriado);
    }

    //LISTA TODOS OS EMPRÉSTIMOS
    @GetMapping()
    public ResponseEntity<List<Emprestimo>> retornarTodosEmprestimos() {
    List<Emprestimo> emprestimos = this.emprestimoRepository.findAll();
    return ResponseEntity.ok(emprestimos);
    }
    
    //LISTA EMPRÉSTIMOS POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> retornarEmprestimoPorId(@PathVariable Long id) {
        Emprestimo emprestimos = this.emprestimoRepository.findById(id).orElse(null);
        if (id == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(emprestimos);
    }

    //DEVOLVE UM LIVRO DO EMPRÉSTIMO
    @PatchMapping("/{id}")
    public ResponseEntity<Emprestimo> devolverLivro(@PathVariable Long id){
        Emprestimo emprestimo = this.emprestimoRepository.findById(id).orElse(null);
        Long IdLivro = emprestimo.getLivro().getId();
        Livro livro = this.livrorepository.findById(IdLivro).orElse(null);
        livro.setEmprestado(false);
        emprestimo.setStatus("devolvido");
        emprestimoRepository.save(emprestimo);
        livrorepository.save(livro);

        return ResponseEntity.ok(emprestimo);
    }
    
}
