package br.com.fiap.InovaTechDuo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TipoAtividadeValidator.class)
public @interface TipoAtividade {
    String message() default "{atividade.tipo}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
