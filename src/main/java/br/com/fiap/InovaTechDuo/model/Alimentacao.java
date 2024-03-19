package br.com.fiap.InovaTechDuo.model;

import br.com.fiap.InovaTechDuo.validation.TipoAlimentacao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Alimentacao {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Size(min = 3, max = 200)
    private String descricao;

    @TipoAlimentacao
    private String tipo;
    
}
