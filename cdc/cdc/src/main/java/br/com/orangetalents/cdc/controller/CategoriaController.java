package br.com.orangetalents.cdc.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.cdc.model.Categoria;
import br.com.orangetalents.cdc.model.request.NovaCategoriaRequest;

@RestController
public class CategoriaController {

	/*
	 * @Autowired private ProibeNomeDuplicadoCategoriaValidator
	 * proibeNomeDuplicadoCategoriaValidator;
	 * 
	 * @InitBinder
	 * 
	 * public void init(WebDataBinder binder) {
	 * binder.addValidators(proibeNomeDuplicadoCategoriaValidator); }
	 */
	
	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/categoria")
	@Transactional
	public String post (@RequestBody @Valid NovaCategoriaRequest request) {
		Categoria categoria = request.toModel();
		manager.persist(categoria);
		return categoria.toString();
	}
	

}
