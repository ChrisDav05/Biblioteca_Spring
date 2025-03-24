package br.edu.ifpi.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpi.demo.Dto.UsuarioDto;
import br.edu.ifpi.demo.entidades.Usuario;
import br.edu.ifpi.demo.repositories.UsuarioRepository;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
    @Autowired // - O @Autowired é uma anotação do Spring Framework que serve para injeção de dependências. Ele permite que o Spring gerencie a criação e a inicialização de objetos necessários dentro de uma classe, eliminando a necessidade de instanciá-los manualmente com new.
    private UsuarioRepository usuariorepository;

    //CADASTRAR O USUARIO NO BANCO
    @PostMapping
    public ResponseEntity<Usuario> adicionarUsuario (@RequestBody @Valid UsuarioDto dados) {
        Usuario usuarioCriado = new Usuario(dados);
        
        this.usuariorepository.save(usuarioCriado);

        return ResponseEntity.ok(usuarioCriado);
    }
    
    //LISTA TODOS OS USUÁRIOS
    @GetMapping()
    public ResponseEntity<List<Usuario>> selecionarTodosUsuarios() {
        List<Usuario> usuarios = this.usuariorepository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    //LISTA USUÁRIO POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> selecionarUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = this.usuariorepository.findById(id).orElse(null);

        if (usuario == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuario);
    }
    
    // DELETA UM USUÁRIO
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id){
        Usuario usuario = this.usuariorepository.findById(id).orElse(null);

        if (usuario == null){
            return ResponseEntity.notFound().build();
        }

        this.usuariorepository.delete(usuario);
        
        return ResponseEntity.ok("Usuário deletado com sucesso: " + usuario);

    }

    // ATUALIZA POR COMPLETO O USUÁRIO. 
    //OBS.: CASO QUISESSE ALTERAR APENAS ALGUNS ATRIBUTOS DO USUÁRIO, PODERIA USAR O @PatchMapping()
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDto dados) {
        
        Usuario usuario = this.usuariorepository.findById(id).orElse(null);

        if (usuario == null){
            return ResponseEntity.notFound().build();
        }

        usuario.setNome(dados.nome());
        usuario.setEmail(dados.email());

        this.usuariorepository.save(usuario);

        return ResponseEntity.ok(usuario);
    }
}
