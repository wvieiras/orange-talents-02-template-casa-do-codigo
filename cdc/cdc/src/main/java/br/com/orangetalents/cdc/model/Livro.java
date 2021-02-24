package br.com.orangetalents.cdc.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@NotBlank
    private String titulo;
	
	//@NotBlank
    private String resumo;
	
	//@NotBlank
    private String sumario;
	
	//@NotNull
    private BigDecimal preco;
	
	//@NotNull
    private Integer paginas;
	
	//@NotBlank
    private String isbn;
	
	//@NotNull
    private LocalDate dataLancamento;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;
    
    @Deprecated
    public Livro() {
    	
    }
    
    //Construtor
	public Livro(@NotBlank String titulo, @NotBlank String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer paginas, @NotBlank String isbn,
			Autor autor, Categoria categoria) {
		
			this.titulo = titulo;
			this.resumo = resumo;
			this.sumario = sumario;
			this.preco = preco;
			this.paginas = paginas;
			this.isbn = isbn;
			this.autor = autor;
			this.categoria = categoria;
	}
	
	

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco=" + preco
				+ ", paginas=" + paginas + ", isbn=" + isbn + ", dataLancamento=" + dataLancamento + ", categoria="
				+ categoria + ", autor=" + autor + "]";
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

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	
	
    
    
}
