package br.com.fiap.InovaTechDuo.validation;

import br.com.fiap.InovaTechDuo.enums.TipoAtividadeEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoAtividadeValidator implements ConstraintValidator<TipoAtividade, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            TipoAtividadeEnum.valueOf(value.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}
