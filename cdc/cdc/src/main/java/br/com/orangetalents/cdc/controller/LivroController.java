package br.com.orangetalents.cdc.controller;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.cdc.model.Livro;
import br.com.orangetalents.cdc.model.request.NovoLivroRequest;

@RestController
public class LivroController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@GetMapping("/lista-livros")
	@Transactional
	public List<Livro> buscar(){
		return manager.createQuery("select a from Livro a ", Livro.class)
				.getResultList();
	}
	
	@PostMapping("/livro")
	@Transactional
	public String post(@RequestBody @Valid NovoLivroRequest request) {
		Livro livro = request.toModel(manager);
		manager.persist(livro);
		return livro.toString();
		
	}
}
