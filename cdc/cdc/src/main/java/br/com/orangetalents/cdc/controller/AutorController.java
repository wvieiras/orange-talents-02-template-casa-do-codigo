package br.com.orangetalents.cdc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.cdc.model.Autor;
import br.com.orangetalents.cdc.repository.AutorRepository;
import br.com.orangetalents.cdc.validation.ProibeEmailDuplicadoAutorValidator;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	private AutorRepository repository;
	
	@Autowired
	ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;
		
	@InitBinder
	public void init(WebDataBinder binder) {
		
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
	}
	
	
	@PostMapping
	public ResponseEntity<Autor> post (@RequestBody @Valid Autor autor){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(autor));
	}
	
}
