package br.edu.ifpi.demo.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDto(@NotBlank String nome, @NotBlank @Email String email) {
}
