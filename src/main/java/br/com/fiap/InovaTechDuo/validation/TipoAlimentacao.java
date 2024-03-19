package br.com.fiap.InovaTechDuo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
<<<<<<< HEAD
import jakarta.validation.Payload;
=======
>>>>>>> 0f494a6aa03c4ed092f1798e0e8ea1a4b870f772

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TipoAlimentacaoValitador.class)
public @interface TipoAlimentacao {
    String message() default "{alimentacao.tipo}";

<<<<<<< HEAD
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

=======
>>>>>>> 0f494a6aa03c4ed092f1798e0e8ea1a4b870f772
}
