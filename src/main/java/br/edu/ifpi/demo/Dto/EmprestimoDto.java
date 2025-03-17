package br.edu.ifpi.demo.Dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;

public record EmprestimoDto(@NotBlank Long livro_id, @NotBlank Long usuario_id, @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDate dataEmprestimo, @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDate dataDevolucao, @NotBlank String status){
}
