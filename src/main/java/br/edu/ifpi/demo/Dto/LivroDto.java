package br.edu.ifpi.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record LivroDto(@NotBlank String autor, @NotBlank String titulo, @NotBlank String editora, @NotNull Integer ano, @Pattern(regexp = "^(\\d{10}|\\d{13})$") String isbn, @NotNull boolean emprestado) {
}
