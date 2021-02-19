package br.com.orangetalents.cdc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.cdc.model.Autor;
import br.com.orangetalents.cdc.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	private AutorRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Autor>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Autor> post (@RequestBody Autor autor){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(autor));
	}
	
}
