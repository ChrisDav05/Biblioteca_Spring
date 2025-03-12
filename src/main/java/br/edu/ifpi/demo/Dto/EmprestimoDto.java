package br.edu.ifpi.demo.Dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.ifpi.demo.entidades.Emprestimo;
import br.edu.ifpi.demo.entidades.Livro;
import br.edu.ifpi.demo.entidades.Usuario;
import jakarta.validation.constraints.NotBlank;

public record EmprestimoDto(@NotBlank Livro livro, @NotBlank Usuario usuario, @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDate dataEmprestimo, @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDate dataDevolucao, @NotBlank String status){
}
