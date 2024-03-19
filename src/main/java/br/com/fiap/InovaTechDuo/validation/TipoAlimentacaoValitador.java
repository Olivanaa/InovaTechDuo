package br.com.fiap.InovaTechDuo.validation;



import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class TipoAlimentacaoValitador implements ConstraintValidator<TipoAlimentacao, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("CAFE_DA_MANHA") || value.equals("ALMOCO") || value.equals("JANTAR");
    }

}
