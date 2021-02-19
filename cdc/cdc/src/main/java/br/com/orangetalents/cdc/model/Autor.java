package br.com.orangetalents.cdc.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="tb_autor")
public class Autor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty @NotNull 
	private String name;
	
	@Email @NotEmpty @NotNull @Column(unique=true)
	private String email;
	
	@NotEmpty @NotNull @Size(max=400)
	private String description;
	
	@NotNull
	private LocalDateTime dateCreate = LocalDateTime.now();
	
	
	//Getters
	public Long getId() {
		return id;
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

	public LocalDateTime getDateCreate() {
		return dateCreate;
	}
	
}
