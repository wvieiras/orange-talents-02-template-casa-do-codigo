package br.com.orangetalents.cdc.model.request;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import br.com.orangetalents.cdc.model.Categoria;



public class NovaCategoriaRequest {
	
	@NotBlank @Column(unique = true) 
	private String nome;
		

	public String getNome() {
		return nome;
	}


	//Método toModel()
	public Categoria toModel() {
		return new Categoria(this.nome);
	}
	
	
}
