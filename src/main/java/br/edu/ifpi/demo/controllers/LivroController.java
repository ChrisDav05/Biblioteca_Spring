package br.edu.ifpi.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpi.demo.Dto.LivroDto;
import br.edu.ifpi.demo.entidades.Livro;
import br.edu.ifpi.demo.repositories.LivroRepository;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/livros")

    public class LivroController {
    @Autowired // - O @Autowired é uma anotação do Spring Framework que serve para injeção de dependências. Ele permite que o Spring gerencie a criação e a inicialização de objetos necessários dentro de uma classe, eliminando a necessidade de instanciá-los manualmente com new.

    private LivroRepository livrorepository;
    
    //ADICIONA UM LIVRO NO BANCO DE DADOS
    @PostMapping
    public ResponseEntity<Livro> adicionarLivro(@RequestBody @Valid LivroDto dados) {
        Livro livroCriado = new Livro(dados);
        this.livrorepository.save(livroCriado);
        return ResponseEntity.ok(livroCriado);
    }

    //LISTA TODOS OS LIVROS
    @GetMapping 
    public ResponseEntity<List<Livro>> listarTodosLivros() {
        List<Livro> livros = this.livrorepository.findAll();
        return ResponseEntity.ok(livros);
    }

    //LISTA O LIVRO POR ID
    @GetMapping ("/{id}")
    public ResponseEntity<Livro> listarLivroPorId(@PathVariable Long id){
        Livro livro = this.livrorepository.findById(id).orElse(null);
        if (livro == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(livro);

    }

     // DELETA UM LIVRO
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarLivro(@PathVariable Long id){
        Livro livro = this.livrorepository.findById(id).orElse(null);

        if (livro == null){
            return ResponseEntity.notFound().build();
        }

        this.livrorepository.delete(livro);
        
        return ResponseEntity.ok("Livro deletado com sucesso: " + livro);

    }

    // ATUALIZA POR COMPLETO O LIVRO. 
    //OBS.: CASO QUISESSE ALTERAR APENAS ALGUNS ATRIBUTOS DO LIVRO, PODE-SE USAR O @PatchMapping()
    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody LivroDto dados) {
        
        Livro livro = this.livrorepository.findById(id).orElse(null);

        if (livro == null){
            return ResponseEntity.notFound().build();
        }

        livro.setAutor(dados.autor());
        livro.setTitulo(dados.titulo());
        livro.setEditora(dados.editora());
        livro.setAno(dados.ano());
        livro.setISBN(dados.isbn());
        livro.setEmprestado(dados.emprestado());

        this.livrorepository.save(livro);

        return ResponseEntity.ok(livro);
    }
    

}
