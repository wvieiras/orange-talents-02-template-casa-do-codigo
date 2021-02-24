package br.com.orangetalents.cdc.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.cdc.model.Autor;
import br.com.orangetalents.cdc.model.request.NovoAutorRequest;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	
	
	/*
	 * @Autowired ProibeEmailDuplicadoAutorValidator
	 * proibeEmailDuplicadoAutorValidator;
	 * 
	 * @InitBinder public void init(WebDataBinder binder) {
	 * 
	 * binder.addValidators(proibeEmailDuplicadoAutorValidator); }
	 */
	
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public String post (@RequestBody @Valid NovoAutorRequest request) {
		Autor autor = request.toModel();
		manager.persist(autor);
		return autor.toString();
	}
	
}
