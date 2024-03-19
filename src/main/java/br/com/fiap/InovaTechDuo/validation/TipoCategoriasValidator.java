package br.com.fiap.InovaTechDuo.validation;


import br.com.fiap.InovaTechDuo.enums.CategoriasEnum;
import br.com.fiap.InovaTechDuo.enums.IconesEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoCategoriasValidator implements ConstraintValidator<TipoCategoria, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return isCategoriaValida(value) || isIconeValido(value);
    }

    private boolean isCategoriaValida(String value) {
        try {
            CategoriasEnum.valueOf(value.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean isIconeValido(String value) {
        try {
            IconesEnum.valueOf(value.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}
