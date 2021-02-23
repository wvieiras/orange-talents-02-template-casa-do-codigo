package br.com.orangetalents.cdc.validation;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.orangetalents.cdc.model.Autor;
import br.com.orangetalents.cdc.repository.AutorRepository;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {
	
	@Autowired
	AutorRepository autorRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Autor.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()){
			return;
		}
		
		Autor request = (Autor) target;
		
		Optional<Autor> possivelAutor = autorRepository.findByEmail(request.getEmail());

		if(possivelAutor.isPresent()) {
			errors.rejectValue("Email", null, 
				"Já existe um outro mesmo email cadastro"
				+ request.getEmail());
		}
	}
	
}
