package br.com.orangetalents.cdc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.cdc.model.Categoria;
import br.com.orangetalents.cdc.repository.CategoriaRepository;
import br.com.orangetalents.cdc.validation.ProibeNomeDuplicadoCategoriaValidator;


@RestController
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@Autowired
	private ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator;
	
	@InitBinder
	public void init(WebDataBinder binder){
		binder.addValidators(proibeNomeDuplicadoCategoriaValidator);
	}

	@PostMapping(value  = "/categoria")
	public ResponseEntity<Categoria> post (@RequestBody @Valid Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
}
