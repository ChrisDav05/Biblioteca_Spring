package br.edu.ifpi.demo.entidades;

import java.time.LocalDate;

import br.edu.ifpi.demo.Dto.EmprestimoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "emprestimos")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "livro_id", nullable = false)
    private Livro livro;

    @ManyToOne
    @JoinColumn (name = "usuario_id", nullable = false)
    private Usuario usuario;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private String status;

    public Emprestimo(){

    }

    public Emprestimo(Long id, Livro livro, Usuario usuario, LocalDate dataEmprestimo,
            LocalDate dataDevolucao, String status) {
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
    }

    public Emprestimo(EmprestimoDto emprestimoDto){
        this.livro = emprestimoDto.livro();
        this.usuario = emprestimoDto.usuario();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
