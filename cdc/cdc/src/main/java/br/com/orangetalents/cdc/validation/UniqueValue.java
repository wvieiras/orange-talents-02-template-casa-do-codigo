package br.com.orangetalents.cdc.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = UniqueValueValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
	
	// A mensagem que vai ser aplicada quando a validação falhar
	String message() default "{br.com.orangetalents.cdc.uniquevalue}";
	
	// Para aplicar a validação a um grupo especifico dentro da minha empresa | Quase ninguém usa
	Class<?>[] groups() default {};
	
	//Se quiser mandar informação a mais dentro da minha validação | Quase ninguém usa
	Class <? extends Payload>[] payload() default {};
	
	String fieldName();
	
	Class<?> domainClass();
	
	
}
