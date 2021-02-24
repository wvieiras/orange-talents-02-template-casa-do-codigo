package br.com.orangetalents.cdc.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String email;

	private String description;

	private LocalDateTime dateCreate = LocalDateTime.now();
	
	@Deprecated
	public Autor() {
		
	}
	
	public Autor(@NotBlank String name, @Email @NotBlank String email,
			@NotBlank @Size(max = 400) String description) {
		
		this.name = name;
		this.email = email;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", name=" + name + ", email=" + email + ", description=" + description
				+ ", dateCreate=" + dateCreate + "]";
	}

	//Getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	
}
