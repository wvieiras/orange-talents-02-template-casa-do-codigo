
package br.com.orangetalents.cdc.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.orangetalents.cdc.model.Categoria;
import br.com.orangetalents.cdc.repository.CategoriaRepository;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return Categoria.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		Categoria request = (Categoria) target;
		Optional<Categoria> possivelNome = categoriaRepository.findByNome(request.getNome());

		if (possivelNome.isPresent()) {
			errors.rejectValue("Nome", null, "Já existe um outro nome igual maninho" + request.getNome());
		}
	}
}
