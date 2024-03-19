package br.com.fiap.InovaTechDuo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TipoAlimentacaoValitador.class)
public @interface TipoAlimentacao {
    String message() default "{alimentacao.tipo}";

}
