package br.com.orangetalents.cdc.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private String nome;
	
	
	@Deprecated
    public Categoria() {
	}


	//Construtor   
	public Categoria(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	
	//toString
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}


	//Getters
	public Long getId() {
		return id;
	}	


	public String getNome() {
		return nome;
	}
	
	

}
