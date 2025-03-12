package br.edu.ifpi.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpi.demo.Dto.EmprestimoDto;
import br.edu.ifpi.demo.entidades.Emprestimo;
import br.edu.ifpi.demo.repositories.EmprestimoRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/emprestimos")
@RestController
public class EmprestimoController {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    //ADICIONA UM EMPRÉSTIMO NO BANCO DE DADOS
    
    
    @PostMapping()
    public ResponseEntity<Emprestimo> adicionarEmprestimo(@RequestBody @Valid EmprestimoDto dados) {
        Emprestimo emprestimoCriado = new Emprestimo(dados);
        this.emprestimoRepository.save(emprestimoCriado);
        return ResponseEntity.ok(emprestimoCriado);
    }
    
}
