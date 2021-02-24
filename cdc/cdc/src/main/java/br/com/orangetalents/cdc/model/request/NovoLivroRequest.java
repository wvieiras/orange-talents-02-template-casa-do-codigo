package br.com.orangetalents.cdc.model.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.orangetalents.cdc.model.Autor;
import br.com.orangetalents.cdc.model.Categoria;
import br.com.orangetalents.cdc.model.Livro;

public class NovoLivroRequest {
	
    @NotBlank
    private String titulo;

    @NotBlank
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer paginas;

    @NotBlank
    private String isbn;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
    private LocalDate dataLancamento;

    @NotNull
    @ManyToOne
    private Long idCategoria;

    @NotNull
    @ManyToOne
    private Long idAutor;
    
    @Deprecated
    public NovoLivroRequest() {
    	
    }

	public NovoLivroRequest(@NotBlank String titulo, @NotBlank String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer paginas, @NotBlank String isbn,
			@NotNull Long idCategoria, @NotNull Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	
	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}


	public Livro toModel(EntityManager manager) {
		Autor autor = manager.find(Autor.class, idAutor);
		Categoria categoria = manager.find(Categoria.class, idCategoria);
		return new Livro(titulo, resumo, sumario, preco, paginas, isbn, autor, categoria);
	}


	public String getTitulo() {
		return titulo;
	}


	public String getResumo() {
		return resumo;
	}


	public String getSumario() {
		return sumario;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public Integer getPaginas() {
		return paginas;
	}


	public String getIsbn() {
		return isbn;
	}


	public LocalDate getDataLancamento() {
		return dataLancamento;
	}


	public Long getIdCategoria() {
		return idCategoria;
	}


	public Long getIdAutor() {
		return idAutor;
	}
	
	
	
	
    
    
	
}
