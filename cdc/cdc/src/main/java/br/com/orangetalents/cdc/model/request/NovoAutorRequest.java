package br.com.orangetalents.cdc.model.request;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.orangetalents.cdc.model.Autor;

public class NovoAutorRequest {
	
	@NotBlank
	private String name;
	
	@Email @NotBlank @Column(unique=true)
	private String email;
	
	@NotBlank @Size(max=400)
	private String description;

	public NovoAutorRequest(@NotBlank String name, @Email @NotBlank String email,
			@NotBlank @Size(max = 400) String description, @NotNull LocalDateTime dateCreate) {
		super();
		this.name = name;
		this.email = email;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getDescription() {
		return description;
	}

	public Autor toModel() {
		
		return new Autor(this.name,this.email,this.description);
	}
	
	
}
