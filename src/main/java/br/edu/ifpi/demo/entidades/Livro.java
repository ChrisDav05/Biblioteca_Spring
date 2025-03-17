package br.edu.ifpi.demo.entidades;

import br.edu.ifpi.demo.Dto.LivroDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String editora;

    @Column(nullable = false)
    private int ano;

    @Column(nullable = false, unique = true)
    private String ISBN;

    @Column(nullable = false)
    private Boolean emprestado;

    public Livro(){

    }
    
    public Livro(Long id, String autor, String titulo, String editora, int ano, String ISBN,
            Boolean emprestado) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.editora = editora;
        this.ano = ano;
        this.ISBN = ISBN;
        this.emprestado = emprestado;
    }

    public Livro(LivroDto livroDto){
        this.autor = livroDto.autor();
        this.titulo = livroDto.titulo();
        this.editora = livroDto.editora();
        this.ano = livroDto.ano();
        this.ISBN = livroDto.isbn();
        this.emprestado = livroDto.emprestado();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Boolean getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(Boolean emprestado) {
        this.emprestado = emprestado;
    }
    
}
