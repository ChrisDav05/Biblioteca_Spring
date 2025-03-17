package br.edu.ifpi.demo.Dto;

import jakarta.validation.constraints.NotBlank;

public record CreateEmpReqDto(@NotBlank Long livro_id, @NotBlank Long usuario_id){
}
